package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * A model that saves [Bundle] and returns the last returned one.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/browser/tab/RecentTabModel;", "", "()V", "bundleStack", "Ljava/util/Stack;", "Landroid/os/Bundle;", "addClosedTab", "", "savedBundle", "lastClosed", "app_lightningPlusDebug"})
public final class RecentTabModel {
    private final java.util.Stack<android.os.Bundle> bundleStack = null;
    
    /**
     * Return the last closed tab as a [Bundle] or null if there is no previously opened tab.
     * Removes the [Bundle] from the queue after returning it.
     */
    @org.jetbrains.annotations.Nullable()
    public final android.os.Bundle lastClosed() {
        return null;
    }
    
    /**
     * Add the [savedBundle] to the queue. The next call to [lastClosed] will return this [Bundle].
     */
    public final boolean addClosedTab(@org.jetbrains.annotations.NotNull()
    android.os.Bundle savedBundle) {
        return false;
    }
    
    @javax.inject.Inject()
    public RecentTabModel() {
        super();
    }
}