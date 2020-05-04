package com.goonigoop.files;

import com.goonigoop.strings.StringGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class FileChecker {
    public long countWordsInFile(String name) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(name)));
        String s = bufferedReader.readLine();
        int res = 0;
        while (nonNull(s)) {
            final String[] arr = s.split(" ");
            res += arr.length;
            s = bufferedReader.readLine();
        }
        return res;
    }

    public Map<String, Long> countWords(String name, int maxSize) throws IOException {
        LinkedHashMap<String, Long> stringLongConcurrentHashMap = new LinkedHashMap<>();
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(name)));
        String s = bufferedReader.readLine();
        PriorityQueueWrapper priorityQueueWrapper = new PriorityQueueWrapper(maxSize);
        final ArrayList<String> objects = new ArrayList<>();
        while (nonNull(s)) {
            final String[] s1 = s.split(" ");
            objects.addAll(Arrays.asList(s1));
            s = bufferedReader.readLine();
        }
        objects.stream()
                    .collect(Collectors.toMap(Function.identity(), s2 -> 1L, Long::sum))
                    .forEach((s2, aLong) -> priorityQueueWrapper.add(new Words(s2, aLong)));


        while (!priorityQueueWrapper.words.isEmpty()) {
            final Words poll = priorityQueueWrapper.words.poll();
            stringLongConcurrentHashMap.put(poll.word, poll.count);
        }

        return stringLongConcurrentHashMap;

    }

    public static void main(String[] args) throws IOException {
        FileChecker fileChecker = new FileChecker();
        final StringGenerator stringGenerator = new StringGenerator();
        final String pathname = "temp.log";
        final String name = stringGenerator.generateFile(pathname,20);
        final long l = fileChecker.countWordsInFile(name);
        System.out.println(l);
        final Map<String, Long> map = fileChecker.countWords(name, 15);
        System.out.println(map.size());

        map.entrySet().removeIf(s -> s.getValue() < 1);
        System.out.println(map);

    }


    private static class Words {
        String word;
        Long count;

        public Words(String word, Long count) {
            this.word = word;
            this.count = count;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }

    private static class PriorityQueueWrapper {
        PriorityQueue<Words> words;
        int maxSize;

        public PriorityQueueWrapper(int maxSize) {
            this.maxSize = maxSize;
            words = new PriorityQueue<>(Comparator.comparingLong(Words::getCount));
        }


        public void add(Words word) {
            if (words.size() < this.maxSize) {
                this.words.offer(word);
            } else if (Objects.requireNonNull(this.words.peek()).getCount() < word.getCount()) {
                words.poll();
                words.offer(word);
            }
        }
    }
}
