package acr.browser.lightning.html.bookmark;

import java.lang.System;

/**
 * The store for the bookmarks HTML.
 */
@com.anthonycr.mezzanine.FileStream(value = "app/src/main/html/bookmarks.html")
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lacr/browser/lightning/html/bookmark/BookmarkPageReader;", "", "provideHtml", "", "app_lightningLiteDebug"})
public abstract interface BookmarkPageReader {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String provideHtml();
}