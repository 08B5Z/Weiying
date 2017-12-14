package com.example.administrator.weiying.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */

public class CommentaryBean {

    /**
     * msg : 成功
     * ret : {"pnum":1,"totalRecords":14,"records":20,"list":[{"msg":"有啥好看的推荐几个。最好是高能的","phoneNumber":"一sui人","dataId":"ff8080815fa38f91015fc28adf205ed8","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL0vn8eTNt7sZATzFRrg8LhjYs9SBib4B3sFQic3hG0FwKRWoxKJ1X3WpFBGp8Zrt5uFC66myESmfgg/0","time":"2017-11-16 09:56:41","likeNum":0},{"msg":"第一部忍者神龟剧情不错比第二部的剧情要好很多","phoneNumber":"187****2781","dataId":"ff8080815f387ddb015f499b22e766e9","userPic":"","time":"2017-10-23 22:20:24","likeNum":2},{"msg":"免费","phoneNumber":"150****3579","dataId":"ff8080815ec76f46015eeccb759f0e36","userPic":"","time":"2017-10-05 21:48:30","likeNum":0},{"msg":"。","phoneNumber":"186****0076","dataId":"ff8080815e7fa211015e807247980784","userPic":"","time":"2017-09-14 20:52:06","likeNum":3},{"msg":"太太太不好妤好看看了","phoneNumber":"高势猛","dataId":"ff8080815e03962e015e0439c7f701bf","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/08/21/1503276938934414535.jpg","time":"2017-08-21 17:57:29","likeNum":1},{"msg":"有人吗","phoneNumber":"童年无忌","dataId":"ff8080815de4a85a015df39f320d4618","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/08/08/1502165026587497618.jpg","time":"2017-08-18 12:34:42","likeNum":2},{"msg":"\u201c家门\u201d是日语？！mdzz","phoneNumber":"134****9682","dataId":"ff8080815da18adf015da78986512421","userPic":"","time":"2017-08-03 17:59:54","likeNum":2},{"msg":"评论都是电脑吗？","phoneNumber":"心善.🍂","dataId":"ff8080815d078bbc015d21f8a09363cd","userPic":"http://q.qlogo.cn/qqapp/1101034181/10EACBA7CFB59CB1FB84ABBBEF224062/40","time":"2017-07-08 19:32:08","likeNum":3},{"msg":"行吗","phoneNumber":"134****4435","dataId":"ff8080815d078b01015d1b724baa1064","userPic":"","time":"2017-07-07 13:07:41","likeNum":1},{"msg":"其实每个团队都有一个逗逼","phoneNumber":"158****2013","dataId":"ff8080815d078bbc015d0d237411582a","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/07/04/1499164078761248973.jpg","time":"2017-07-04 18:26:53","likeNum":3},{"msg":"导演给力，演员给力，这样的电影真的不多了，支持！","phoneNumber":"给你快乐","dataId":"ff8080815d078bbc015d0c3f8dab4943","userPic":"","time":"2017-06-24 14:17:57","likeNum":7},{"msg":"呵呵，这种电影，不想评价更多！","phoneNumber":"陌路丢了谁","dataId":"ff8080815d078bbc015d0c3f8da94942","userPic":"","time":"2017-06-21 05:17:57","likeNum":10},{"msg":"还行吧，值得一看。","phoneNumber":"自欺欺人","dataId":"ff8080815d078bbc015d0c3f8da64941","userPic":"","time":"2017-06-14 02:17:57","likeNum":7},{"msg":"在豆瓣上看到这个片子的，看完之后，觉得没他们评价的那么糟嘛。","phoneNumber":"初夏。浅笑","dataId":"ff8080815d078bbc015d0c3f8dac4944","userPic":"","time":"2017-06-09 07:09:57","likeNum":5}],"totalPnum":1}
     * code : 200
     */

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean {
        /**
         * pnum : 1
         * totalRecords : 14
         * records : 20
         * list : [{"msg":"有啥好看的推荐几个。最好是高能的","phoneNumber":"一sui人","dataId":"ff8080815fa38f91015fc28adf205ed8","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL0vn8eTNt7sZATzFRrg8LhjYs9SBib4B3sFQic3hG0FwKRWoxKJ1X3WpFBGp8Zrt5uFC66myESmfgg/0","time":"2017-11-16 09:56:41","likeNum":0},{"msg":"第一部忍者神龟剧情不错比第二部的剧情要好很多","phoneNumber":"187****2781","dataId":"ff8080815f387ddb015f499b22e766e9","userPic":"","time":"2017-10-23 22:20:24","likeNum":2},{"msg":"免费","phoneNumber":"150****3579","dataId":"ff8080815ec76f46015eeccb759f0e36","userPic":"","time":"2017-10-05 21:48:30","likeNum":0},{"msg":"。","phoneNumber":"186****0076","dataId":"ff8080815e7fa211015e807247980784","userPic":"","time":"2017-09-14 20:52:06","likeNum":3},{"msg":"太太太不好妤好看看了","phoneNumber":"高势猛","dataId":"ff8080815e03962e015e0439c7f701bf","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/08/21/1503276938934414535.jpg","time":"2017-08-21 17:57:29","likeNum":1},{"msg":"有人吗","phoneNumber":"童年无忌","dataId":"ff8080815de4a85a015df39f320d4618","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/08/08/1502165026587497618.jpg","time":"2017-08-18 12:34:42","likeNum":2},{"msg":"\u201c家门\u201d是日语？！mdzz","phoneNumber":"134****9682","dataId":"ff8080815da18adf015da78986512421","userPic":"","time":"2017-08-03 17:59:54","likeNum":2},{"msg":"评论都是电脑吗？","phoneNumber":"心善.🍂","dataId":"ff8080815d078bbc015d21f8a09363cd","userPic":"http://q.qlogo.cn/qqapp/1101034181/10EACBA7CFB59CB1FB84ABBBEF224062/40","time":"2017-07-08 19:32:08","likeNum":3},{"msg":"行吗","phoneNumber":"134****4435","dataId":"ff8080815d078b01015d1b724baa1064","userPic":"","time":"2017-07-07 13:07:41","likeNum":1},{"msg":"其实每个团队都有一个逗逼","phoneNumber":"158****2013","dataId":"ff8080815d078bbc015d0d237411582a","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/07/04/1499164078761248973.jpg","time":"2017-07-04 18:26:53","likeNum":3},{"msg":"导演给力，演员给力，这样的电影真的不多了，支持！","phoneNumber":"给你快乐","dataId":"ff8080815d078bbc015d0c3f8dab4943","userPic":"","time":"2017-06-24 14:17:57","likeNum":7},{"msg":"呵呵，这种电影，不想评价更多！","phoneNumber":"陌路丢了谁","dataId":"ff8080815d078bbc015d0c3f8da94942","userPic":"","time":"2017-06-21 05:17:57","likeNum":10},{"msg":"还行吧，值得一看。","phoneNumber":"自欺欺人","dataId":"ff8080815d078bbc015d0c3f8da64941","userPic":"","time":"2017-06-14 02:17:57","likeNum":7},{"msg":"在豆瓣上看到这个片子的，看完之后，觉得没他们评价的那么糟嘛。","phoneNumber":"初夏。浅笑","dataId":"ff8080815d078bbc015d0c3f8dac4944","userPic":"","time":"2017-06-09 07:09:57","likeNum":5}]
         * totalPnum : 1
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * msg : 有啥好看的推荐几个。最好是高能的
             * phoneNumber : 一sui人
             * dataId : ff8080815fa38f91015fc28adf205ed8
             * userPic : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL0vn8eTNt7sZATzFRrg8LhjYs9SBib4B3sFQic3hG0FwKRWoxKJ1X3WpFBGp8Zrt5uFC66myESmfgg/0
             * time : 2017-11-16 09:56:41
             * likeNum : 0
             */

            private String msg;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
