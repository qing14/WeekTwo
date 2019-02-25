package asus.com.bwie.marketcxy.bean;

import java.util.List;

public class CircleListBean {


    /**
     * result : [{"commodityId":1,"content":"只是无奈这些问题无人交流","createTime":1546031563000,"greatNum":38,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-14/20181214202231.jpg","id":238,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-28/7861220181228151243.jpg","nickName":"后来呢","userId":17,"whetherGreat":2},{"commodityId":1,"content":"zyz","createTime":1545788982000,"greatNum":20,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":237,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-25/1039420181225194942.png","nickName":"fy_Nt8h8","userId":91,"whetherGreat":2},{"commodityId":7,"content":"","createTime":1545341013000,"greatNum":13,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-18/20181218160753.jpg","id":236,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-20/8436520181220152333.jpg","nickName":"少年闰土","userId":186,"whetherGreat":2},{"commodityId":6,"content":"要答辩了，超不爽","createTime":1545234528000,"greatNum":48,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-18/20181218160753.jpg","id":235,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-19/9076320181219094848.jpg","nickName":"少年闰土","userId":186,"whetherGreat":2},{"commodityId":4,"content":"吼吼吼","createTime":1545234310000,"greatNum":10,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-18/20181218160753.jpg","id":234,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-19/9780320181219094510.gif","nickName":"少年闰土","userId":186,"whetherGreat":2},{"commodityId":1,"content":"一开始,装作不经意","createTime":1545172681000,"greatNum":19,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":233,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-18/1795620181218163801.jpg","nickName":"cn_511z6","userId":83,"whetherGreat":2},{"commodityId":4,"content":"嗯哼？","createTime":1545171516000,"greatNum":11,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-18/20181218160753.jpg","id":232,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-18/1608220181218161836.JPEG","nickName":"少年闰土","userId":186,"whetherGreat":2},{"commodityId":3,"content":"谁是闰土心里没点逼数吗？瞎乐","createTime":1545170981000,"greatNum":4,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-18/20181218160753.jpg","id":231,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-18/2648320181218160941.jpg","nickName":"少年闰土","userId":186,"whetherGreat":2},{"commodityId":2,"content":"大家好我才是闰土","createTime":1545170581000,"greatNum":4,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-18/20181218160753.jpg","id":230,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-18/4615220181218160301.jpg","nickName":"少年闰土","userId":186,"whetherGreat":2},{"commodityId":1,"content":"大家好我是闰土，我是来找猹的","createTime":1545170161000,"greatNum":2,"headPic":"http://172.17.8.100/images/small/head_pic/2018-12-18/20181218160753.jpg","id":229,"image":"","nickName":"少年闰土","userId":186,"whetherGreat":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 1
         * content : 只是无奈这些问题无人交流
         * createTime : 1546031563000
         * greatNum : 38
         * headPic : http://172.17.8.100/images/small/head_pic/2018-12-14/20181214202231.jpg
         * id : 238
         * image : http://172.17.8.100/images/small/circle_pic/2018-12-28/7861220181228151243.jpg
         * nickName : 后来呢
         * userId : 17
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private long createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
