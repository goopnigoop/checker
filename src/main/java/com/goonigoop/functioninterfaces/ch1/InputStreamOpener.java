package com.goonigoop.functioninterfaces.ch1;

import java.io.InputStream;

public interface InputStreamOpener {
    InputStream open (String name);
}
