package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * An initializer that sets the [WebView] as the target of the [resultMessage]. Used for
 * `target="_blank"` links.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/browser/tab/ResultMessageInitializer;", "Lacr/browser/lightning/browser/tab/TabInitializer;", "resultMessage", "Landroid/os/Message;", "(Landroid/os/Message;)V", "initialize", "", "webView", "Landroid/webkit/WebView;", "headers", "", "", "app_lightningPlusDebug"})
public final class ResultMessageInitializer implements acr.browser.lightning.browser.tab.TabInitializer {
    private final android.os.Message resultMessage = null;
    
    @java.lang.Override()
    public void initialize(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers) {
    }
    
    public ResultMessageInitializer(@org.jetbrains.annotations.NotNull()
    android.os.Message resultMessage) {
        super();
    }
}