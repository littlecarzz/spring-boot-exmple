package com.cjj.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
        private static final long serialVersionUID = -3258839839160856613L;
        private Long uid;
        private String userName;
        private String passWord;



        @Override
        public String toString() {
                return "User{" +
                        "id=" + uid +
                        ", userName='" + userName + '\'' +
                        ", passWord='" + passWord + '\'' +
                        '}';
        }

        public User(String userName, String passWord) {
                this.userName = userName;
                this.passWord = passWord;
        }
}