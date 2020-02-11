/*
 * Copyright 2020 Jim O'Regan <jaoregan@tcd.ie>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package io.github.jimregan.speechtranscriber.subtitles;

import java.util.ArrayList;
import java.util.List;

public class WebVTTRegion {
    String identifier;
    int width;
    int lines_value;
    WebVTTAnchorPoint region;
    WebVTTAnchorPoint region_viewport;
    ScrollValue sv;
    List<WebVTTRegion> regions;

    public enum ScrollValue {
        None,
        Up
    }

    public WebVTTRegion() {
        this.width = 100;
        this.lines_value = 3;
        this.region = new WebVTTAnchorPoint(0, 100);
        this.region_viewport = new WebVTTAnchorPoint(0, 100);
        this.sv = ScrollValue.None;
        this.regions = new ArrayList<>();
    }
}
