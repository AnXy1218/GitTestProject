package com.example.retrofit.data;

/**
 * Created by Leovo on 2016/12/15.
 * 该类是手机号码归属地的实体类
 */
public class PhoneResult {
    /**
     * errNum: 0,
     * retMsg: "success",
     * retData: {"phone": "15210011578","prefix": "1521001","supplier": "移动","province": "北京","city": "北京","suit": "152卡"}
     */
    private int errNum;
    private String retMsg;
    private RetDataEntity retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public static class RetDataEntity{
        //手机号码
        private String phone;
        //号码归属
        private String prefix;
        //运营商
        private String supplier;
        //所属省份
        private String province;
        //所属城市
        private String city;
        //卡类型
        private String suit;
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

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

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

    }

}
