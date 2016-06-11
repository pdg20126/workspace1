package com.example.administrator.workspace.homework;

/**
 * Created by pdg on 2016/6/11.
 */
public class homework_api_guishu_bean {
    public void setRetData(RetDatahomework_api_guishu_bean retData) {
        this.retData = retData;
    }

    public RetDatahomework_api_guishu_bean getRetData() {
        return retData;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public int getErrNum() {
        return errNum;
    }

    public static class RetDatahomework_api_guishu_bean {
        private String phone;
        private String prefix;
        private String supplier;
        private String province;
        private String city;
        private String suit;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }
    }

    /**
     * phone : 15210011578
     * prefix : 1521001
     * supplier : 移动
     * province : 北京
     * city : 北京
     * suit : 152卡
     */

    private RetDatahomework_api_guishu_bean retData;
    private String retMsg;
    /**
     * errNum : 0
     * retMsg : success
     * retData : {"phone":"15210011578","prefix":"1521001","supplier":"移动 ","province":"北京 ","city":"北京 ","suit":"152卡"}
     */

    private int errNum;

}
