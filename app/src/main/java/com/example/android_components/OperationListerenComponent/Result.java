package com.example.android_components.OperationListerenComponent;

public class Result<T> {

    //success subclass
    public final static class Success<T> extends Result{
        private T data;

        public Success(T data){this.data = data;}

        public T getData() {
            return data;
        }
    }

    //error subclass
    public final static class Error extends Result{
        private Exception error;

        public Error(Exception e){this.error = e;}

        public Exception getError() {
            return error;
        }
    }

}
