package com.think.learn_springboot.error;

public class StudentNotFoundException extends RuntimeException {

        public StudentNotFoundException(){
            super();
        }
        public StudentNotFoundException(String message){
        super(message);
       }
}
