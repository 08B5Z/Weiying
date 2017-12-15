package com.example.administrator.weiying.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public class SearchBean {

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

        private String all;
        private String movieNum;
        private int pnum;
        private int totalRecords;
        private String trailerNum;
        private String informationNum;
        private int records;
        private String otherNum;
        private int totalPnum;
        private List<ListBean> list;

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getMovieNum() {
            return movieNum;
        }

        public void setMovieNum(String movieNum) {
            this.movieNum = movieNum;
        }

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

        public String getTrailerNum() {
            return trailerNum;
        }

        public void setTrailerNum(String trailerNum) {
            this.trailerNum = trailerNum;
        }

        public String getInformationNum() {
            return informationNum;
        }

        public void setInformationNum(String informationNum) {
            this.informationNum = informationNum;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public String getOtherNum() {
            return otherNum;
        }

        public void setOtherNum(String otherNum) {
            this.otherNum = otherNum;
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
             * airTime : 2015
             * angleIcon : http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png
             * director : 阿兰·泰勒
             * videoType : 冒险,科幻,动作
             * description : 天网拥有独立意识后，对创造它的人类展开血腥屠杀。未来战争如火如荼，凯尔·里斯（杰·科特尼 Jai Courtney 饰）发现眼前的世界与预计中完全不同，一场关乎人类未来的“人机”大战正式上演。
             * pic : http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/04/1499146505627041847.jpg
             * title : 终结者：创世纪
             * duration : 02:05:36
             * loadtype : video
             * actors : 阿诺·施瓦辛格 / 杰森·克拉科 / 艾米莉亚·克拉克 / 杰·科特尼 / J·K·西蒙斯
             * score : 0
             * dataId : 2b6ae30e59af48fb8a8cbec28535f3cd
             * loadURL : http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=2b6ae30e59af48fb8a8cbec28535f3cd
             * shareURL : http://h5.svipmovie.com/bqdy/2b6ae30e59af48fb8a8cbec28535f3cd.shtml?fromTo=shoujimovie
             * region : 美国
             */

            private int airTime;
            private String angleIcon;
            private String director;
            private String videoType;
            private String description;
            private String pic;
            private String title;
            private String duration;
            private String loadtype;
            private String actors;
            private int score;
            private String dataId;
            private String loadURL;
            private String shareURL;
            private String region;

            public int getAirTime() {
                return airTime;
            }

            public void setAirTime(int airTime) {
                this.airTime = airTime;
            }

            public String getAngleIcon() {
                return angleIcon;
            }

            public void setAngleIcon(String angleIcon) {
                this.angleIcon = angleIcon;
            }

            public String getDirector() {
                return director;
            }

            public void setDirector(String director) {
                this.director = director;
            }

            public String getVideoType() {
                return videoType;
            }

            public void setVideoType(String videoType) {
                this.videoType = videoType;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getLoadtype() {
                return loadtype;
            }

            public void setLoadtype(String loadtype) {
                this.loadtype = loadtype;
            }

            public String getActors() {
                return actors;
            }

            public void setActors(String actors) {
                this.actors = actors;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getLoadURL() {
                return loadURL;
            }

            public void setLoadURL(String loadURL) {
                this.loadURL = loadURL;
            }

            public String getShareURL() {
                return shareURL;
            }

            public void setShareURL(String shareURL) {
                this.shareURL = shareURL;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }
        }
    }
}
