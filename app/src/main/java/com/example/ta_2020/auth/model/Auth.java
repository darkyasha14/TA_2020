package com.example.ta_2020.auth.model;

public class Auth {

    /**
     * code : 0
     * message : success authenticate
     * data : {"user_id":2,"name":"irfan kurniawan","username":"irfankr14","password":"12345678","email":"harneti09@gmail.com","token_text":null,"is_login":true,"is_admin":false,"createdAt":"2020-08-15T18:04:47.000Z","updatedAt":"2020-08-15T18:09:45.000Z"}
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImlyZmFua3IxNCIsImVtYWlsIjoiaGFybmV0aTA5QGdtYWlsLmNvbSIsImlzX2xvZ2luIjp0cnVlLCJpYXQiOjE1OTc1NjA4MjcsImV4cCI6MTU5NzY0NzIyN30.xVhxon4aUI8pBgK1a-ivSyGVSOX9ryqq3K4BuajcPcc
     */

    private int code;
    private String message;
    private DataBean data;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class DataBean {
        /**
         * user_id : 2
         * name : irfan kurniawan
         * username : irfankr14
         * password : 12345678
         * email : harneti09@gmail.com
         * token_text : null
         * is_login : true
         * is_admin : false
         * createdAt : 2020-08-15T18:04:47.000Z
         * updatedAt : 2020-08-15T18:09:45.000Z
         */

        private int user_id;
        private String name;
        private String username;
        private String password;
        private String email;
        private Object token_text;
        private boolean is_login;
        private boolean is_admin;
        private String createdAt;
        private String updatedAt;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getToken_text() {
            return token_text;
        }

        public void setToken_text(Object token_text) {
            this.token_text = token_text;
        }

        public boolean isIs_login() {
            return is_login;
        }

        public void setIs_login(boolean is_login) {
            this.is_login = is_login;
        }

        public boolean isIs_admin() {
            return is_admin;
        }

        public void setIs_admin(boolean is_admin) {
            this.is_admin = is_admin;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
