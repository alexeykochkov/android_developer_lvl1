package com.example.hmw12;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0082\u0001\u0002\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/hmw12/State;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "Loading", "Success", "Lcom/example/hmw12/State$Loading;", "Lcom/example/hmw12/State$Success;", "app_debug"})
public abstract class State {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String text;
    
    private State(java.lang.String text) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getText() {
        return null;
    }
    
    public void setText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/hmw12/State$Loading;", "Lcom/example/hmw12/State;", "()V", "app_debug"})
    public static final class Loading extends com.example.hmw12.State {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.hmw12.State.Loading INSTANCE = null;
        
        private Loading() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/example/hmw12/State$Success;", "Lcom/example/hmw12/State;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "app_debug"})
    public static final class Success extends com.example.hmw12.State {
        @org.jetbrains.annotations.NotNull()
        private java.lang.String text;
        
        public Success(@org.jetbrains.annotations.NotNull()
        java.lang.String text) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getText() {
            return null;
        }
        
        @java.lang.Override()
        public void setText(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
    }
}