/*
 * This file is part of LexLauncher, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014-2017, Jamie Mansfield <https://github.com/jamierocks>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package uk.jamierocks.lexlauncher.util;

import java.util.function.Predicate;

/**
 * Represents common operating systems.
 */
public enum OperatingSystem implements Predicate<String> {

    OSX("mac"),
    LINUX("nix", "nux"),
    WINDOWS("win"),
    UNKNOWN;

    private final String[] partials;

    OperatingSystem(String... partials) {
        this.partials = partials;
    }

    @Override
    public boolean test(String s) {
        for (String partial : this.partials) {
            if (s.contains(partial)) {
                return true;
            }
        }
        return false;
    }

    public String getAppDataFolder() {
        switch (this) {
            case OSX:
                return System.getProperty("user.home") + "/Library/Application Support/lexlauncher";
            case WINDOWS:
                return System.getenv("APPDATA") + ".lexlauncher";
            case LINUX:
            case UNKNOWN:
            default:
                return System.getProperty("user.home") + "lexlauncher";
        }
    }

    /**
     * Gets the operating system currently running on the user's system.
     *
     * @return The current {@link OperatingSystem}.
     */
    public static OperatingSystem getOs() {
        final String osName = System.getProperty("os.name").toLowerCase();

        for (OperatingSystem os : values()) {
            if (os.test(osName)) {
                return os;
            }
        }

        return OperatingSystem.UNKNOWN;
    }

}
