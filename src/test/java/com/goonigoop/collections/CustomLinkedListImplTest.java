package com.goonigoop.collections;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

class CustomLinkedListImplTest {

    CustomLinkedList<String> cll= new CustomLinkedListImpl<>();;

    @BeforeEach
    void setUp() {
        cll = new CustomLinkedListImpl<>();
    }

    @Test
    void testThatCustomLinkedListSizeIncreasedAfterAdd() {
        int currentSize = cll.getCurrentSize();
        cll.add("New Element");
        assertThat(currentSize+1, is(cll.getCurrentSize()));
    }

    @Test
    void testThatCanAddAtIndexElements() {
        cll.add("1");
        cll.add("2");
        cll.add("3");
        ImmutableList<String> list = ImmutableList.of(cll.get(0), cll.get(1), cll.get(2));
        assertThat(list, contains("1","2","3"));
        cll.addAtIndex("4",1);
        cll.addAtIndex("100",0);
        List<String> listOfElements = IntStream.range(0, cll.getCurrentSize())
                                        .boxed()
                                        .map(cll::get)
                                        .collect(Collectors.toList());
        assertThat(listOfElements, contains("100","1","4","2","3"));
    }

    @Test
    void testThatCanAddSeveralElements() {
        cll.add("1");
        cll.add("2");
        cll.add("3");
        ImmutableList<String> list = ImmutableList.of(cll.get(0), cll.get(1), cll.get(2));
        assertThat(list, contains("1","2","3"));
    }

    @Test
    void testThatCanRemoveElement() {
        cll.add("1");
        cll.add("2");
        cll.add("3");
        assertThat(cll.getCurrentSize(), is(3));
        cll.remove(1);
        ImmutableList<String> list = ImmutableList.of(cll.get(0), cll.get(1));
        assertThat(list, contains("1","3"));
        assertThat(cll.getCurrentSize(), is(2));
    }

    @Test
    void testThatCanGetElementByIndex() {
        cll.add("1");
        cll.add("2");
        cll.add("3");
        assertThat(cll.getCurrentSize(), is(3));
        assertThat(cll.get(1), is("2"));
    }

    @Test
    void testThatListContainsElement() {
        cll.add("1");
        cll.add("2");
        cll.add("3");
        assertThat(cll.contains("1"), is(TRUE));
        assertThat(cll.contains("2"), is(TRUE));
        assertThat(cll.contains("3"), is(TRUE));
        assertThat(cll.getCurrentSize(), is(3));
        cll.remove(1);
        assertThat(cll.contains("2"), is(FALSE));
        assertThat(cll.getCurrentSize(), is(2));
    }

}