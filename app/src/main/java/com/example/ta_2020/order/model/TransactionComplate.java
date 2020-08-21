package com.example.ta_2020.order.model;

import java.util.List;

public class TransactionComplate {

    /**
     * code : 0
     * message : successs get data transaction complate by ID
     * data : [{"transactionCom_id":1,"user_id":2,"invoice_no":"082177","conf_payment_id":1,"createdAt":"2020-08-21T13:04:04.000Z","updatedAt":"2020-08-21T13:04:04.000Z","Booking":{"invoice_no":"082177","user_id":2,"jasa_id":2,"payment_status":"PAID","createdAt":"2020-08-21T08:03:18.000Z","updatedAt":"2020-08-21T13:04:04.000Z","Jasa":{"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z","Sub_category":{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z","Category":{"category_id":1,"category_name":"CATEGORY 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z"}}}},"ConPayment":{"conf_payment_id":1,"name":"testname","email":"app@app.com","payment_date":"2012-01-01T00:00:00.000Z","total_price":2738,"payment_method":"bni","invoice_no":"082177","description":"test desc","img_pay":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/082177.png","createdAt":"2020-08-21T13:02:27.000Z","updatedAt":"2020-08-21T13:02:27.000Z"},"User":{"user_id":2,"name":"irfan kurniawan","username":"irfankr14","password":"12345678","email":"harneti09@gmail.com","token_text":null,"is_login":true,"is_admin":false,"createdAt":"2020-08-15T18:04:47.000Z","updatedAt":"2020-08-15T18:09:45.000Z","Profil":{"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}}}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * transactionCom_id : 1
         * user_id : 2
         * invoice_no : 082177
         * conf_payment_id : 1
         * createdAt : 2020-08-21T13:04:04.000Z
         * updatedAt : 2020-08-21T13:04:04.000Z
         * Booking : {"invoice_no":"082177","user_id":2,"jasa_id":2,"payment_status":"PAID","createdAt":"2020-08-21T08:03:18.000Z","updatedAt":"2020-08-21T13:04:04.000Z","Jasa":{"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z","Sub_category":{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z","Category":{"category_id":1,"category_name":"CATEGORY 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z"}}}}
         * ConPayment : {"conf_payment_id":1,"name":"testname","email":"app@app.com","payment_date":"2012-01-01T00:00:00.000Z","total_price":2738,"payment_method":"bni","invoice_no":"082177","description":"test desc","img_pay":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/082177.png","createdAt":"2020-08-21T13:02:27.000Z","updatedAt":"2020-08-21T13:02:27.000Z"}
         * User : {"user_id":2,"name":"irfan kurniawan","username":"irfankr14","password":"12345678","email":"harneti09@gmail.com","token_text":null,"is_login":true,"is_admin":false,"createdAt":"2020-08-15T18:04:47.000Z","updatedAt":"2020-08-15T18:09:45.000Z","Profil":{"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}}
         */

        private int transactionCom_id;
        private int user_id;
        private String invoice_no;
        private int conf_payment_id;
        private String createdAt;
        private String updatedAt;
        private BookingBean Booking;
        private ConPaymentBean ConPayment;
        private UserBean User;

        public int getTransactionCom_id() {
            return transactionCom_id;
        }

        public void setTransactionCom_id(int transactionCom_id) {
            this.transactionCom_id = transactionCom_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getInvoice_no() {
            return invoice_no;
        }

        public void setInvoice_no(String invoice_no) {
            this.invoice_no = invoice_no;
        }

        public int getConf_payment_id() {
            return conf_payment_id;
        }

        public void setConf_payment_id(int conf_payment_id) {
            this.conf_payment_id = conf_payment_id;
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

        public BookingBean getBooking() {
            return Booking;
        }

        public void setBooking(BookingBean Booking) {
            this.Booking = Booking;
        }

        public ConPaymentBean getConPayment() {
            return ConPayment;
        }

        public void setConPayment(ConPaymentBean ConPayment) {
            this.ConPayment = ConPayment;
        }

        public UserBean getUser() {
            return User;
        }

        public void setUser(UserBean User) {
            this.User = User;
        }

        public static class BookingBean {
            /**
             * invoice_no : 082177
             * user_id : 2
             * jasa_id : 2
             * payment_status : PAID
             * createdAt : 2020-08-21T08:03:18.000Z
             * updatedAt : 2020-08-21T13:04:04.000Z
             * Jasa : {"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z","Sub_category":{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z","Category":{"category_id":1,"category_name":"CATEGORY 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z"}}}
             */

            private String invoice_no;
            private int user_id;
            private int jasa_id;
            private String payment_status;
            private String createdAt;
            private String updatedAt;
            private JasaBean Jasa;

            public String getInvoice_no() {
                return invoice_no;
            }

            public void setInvoice_no(String invoice_no) {
                this.invoice_no = invoice_no;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getJasa_id() {
                return jasa_id;
            }

            public void setJasa_id(int jasa_id) {
                this.jasa_id = jasa_id;
            }

            public String getPayment_status() {
                return payment_status;
            }

            public void setPayment_status(String payment_status) {
                this.payment_status = payment_status;
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

            public JasaBean getJasa() {
                return Jasa;
            }

            public void setJasa(JasaBean Jasa) {
                this.Jasa = Jasa;
            }

            public static class JasaBean {
                /**
                 * jasa_id : 2
                 * sub_category_id : 1
                 * jasa_name : jasa test 2
                 * jasa_desc : test desc 123
                 * jasa_price : 10000
                 * createdAt : 2020-08-17T15:44:08.000Z
                 * updatedAt : 2020-08-17T15:44:08.000Z
                 * Sub_category : {"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z","Category":{"category_id":1,"category_name":"CATEGORY 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z"}}
                 */

                private int jasa_id;
                private int sub_category_id;
                private String jasa_name;
                private String jasa_desc;
                private int jasa_price;
                private String createdAt;
                private String updatedAt;
                private SubCategoryBean Sub_category;

                public int getJasa_id() {
                    return jasa_id;
                }

                public void setJasa_id(int jasa_id) {
                    this.jasa_id = jasa_id;
                }

                public int getSub_category_id() {
                    return sub_category_id;
                }

                public void setSub_category_id(int sub_category_id) {
                    this.sub_category_id = sub_category_id;
                }

                public String getJasa_name() {
                    return jasa_name;
                }

                public void setJasa_name(String jasa_name) {
                    this.jasa_name = jasa_name;
                }

                public String getJasa_desc() {
                    return jasa_desc;
                }

                public void setJasa_desc(String jasa_desc) {
                    this.jasa_desc = jasa_desc;
                }

                public int getJasa_price() {
                    return jasa_price;
                }

                public void setJasa_price(int jasa_price) {
                    this.jasa_price = jasa_price;
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

                public SubCategoryBean getSub_category() {
                    return Sub_category;
                }

                public void setSub_category(SubCategoryBean Sub_category) {
                    this.Sub_category = Sub_category;
                }

                public static class SubCategoryBean {
                    /**
                     * sub_category_id : 1
                     * category_id : 1
                     * sub_category_name : sub category 1
                     * sub_category_desc : test desc
                     * img_url : https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png
                     * createdAt : 2020-08-17T15:39:39.000Z
                     * updatedAt : 2020-08-17T15:39:39.000Z
                     * Category : {"category_id":1,"category_name":"CATEGORY 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z"}
                     */

                    private int sub_category_id;
                    private int category_id;
                    private String sub_category_name;
                    private String sub_category_desc;
                    private String img_url;
                    private String createdAt;
                    private String updatedAt;
                    private CategoryBean Category;

                    public int getSub_category_id() {
                        return sub_category_id;
                    }

                    public void setSub_category_id(int sub_category_id) {
                        this.sub_category_id = sub_category_id;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public String getSub_category_name() {
                        return sub_category_name;
                    }

                    public void setSub_category_name(String sub_category_name) {
                        this.sub_category_name = sub_category_name;
                    }

                    public String getSub_category_desc() {
                        return sub_category_desc;
                    }

                    public void setSub_category_desc(String sub_category_desc) {
                        this.sub_category_desc = sub_category_desc;
                    }

                    public String getImg_url() {
                        return img_url;
                    }

                    public void setImg_url(String img_url) {
                        this.img_url = img_url;
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

                    public CategoryBean getCategory() {
                        return Category;
                    }

                    public void setCategory(CategoryBean Category) {
                        this.Category = Category;
                    }

                    public static class CategoryBean {
                        /**
                         * category_id : 1
                         * category_name : CATEGORY 1
                         * category_desc : test desc
                         * createdAt : 2020-08-17T15:37:30.000Z
                         * updatedAt : 2020-08-17T15:37:30.000Z
                         */

                        private int category_id;
                        private String category_name;
                        private String category_desc;
                        private String createdAt;
                        private String updatedAt;

                        public int getCategory_id() {
                            return category_id;
                        }

                        public void setCategory_id(int category_id) {
                            this.category_id = category_id;
                        }

                        public String getCategory_name() {
                            return category_name;
                        }

                        public void setCategory_name(String category_name) {
                            this.category_name = category_name;
                        }

                        public String getCategory_desc() {
                            return category_desc;
                        }

                        public void setCategory_desc(String category_desc) {
                            this.category_desc = category_desc;
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
            }
        }

        public static class ConPaymentBean {
            /**
             * conf_payment_id : 1
             * name : testname
             * email : app@app.com
             * payment_date : 2012-01-01T00:00:00.000Z
             * total_price : 2738
             * payment_method : bni
             * invoice_no : 082177
             * description : test desc
             * img_pay : https://darkyasha.goes2nobel.com/TA/back-end/./public/image/082177.png
             * createdAt : 2020-08-21T13:02:27.000Z
             * updatedAt : 2020-08-21T13:02:27.000Z
             */

            private int conf_payment_id;
            private String name;
            private String email;
            private String payment_date;
            private int total_price;
            private String payment_method;
            private String invoice_no;
            private String description;
            private String img_pay;
            private String createdAt;
            private String updatedAt;

            public int getConf_payment_id() {
                return conf_payment_id;
            }

            public void setConf_payment_id(int conf_payment_id) {
                this.conf_payment_id = conf_payment_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPayment_date() {
                return payment_date;
            }

            public void setPayment_date(String payment_date) {
                this.payment_date = payment_date;
            }

            public int getTotal_price() {
                return total_price;
            }

            public void setTotal_price(int total_price) {
                this.total_price = total_price;
            }

            public String getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(String payment_method) {
                this.payment_method = payment_method;
            }

            public String getInvoice_no() {
                return invoice_no;
            }

            public void setInvoice_no(String invoice_no) {
                this.invoice_no = invoice_no;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getImg_pay() {
                return img_pay;
            }

            public void setImg_pay(String img_pay) {
                this.img_pay = img_pay;
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

        public static class UserBean {
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
             * Profil : {"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}
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
            private ProfilBean Profil;

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

            public ProfilBean getProfil() {
                return Profil;
            }

            public void setProfil(ProfilBean Profil) {
                this.Profil = Profil;
            }

            public static class ProfilBean {
                /**
                 * profil_id : 2
                 * user_id : 2
                 * phone : null
                 * user_img : null
                 * createdAt : 2020-08-15T18:04:48.000Z
                 * updatedAt : 2020-08-15T18:04:48.000Z
                 */

                private int profil_id;
                private int user_id;
                private Object phone;
                private Object user_img;
                private String createdAt;
                private String updatedAt;

                public int getProfil_id() {
                    return profil_id;
                }

                public void setProfil_id(int profil_id) {
                    this.profil_id = profil_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getUser_img() {
                    return user_img;
                }

                public void setUser_img(Object user_img) {
                    this.user_img = user_img;
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
    }
}
