//处理页面上的分页 
function pages(totalPage, pageNum, jspname) {

    if (totalPage == 0) {
        var con = "共" + 0 + "页 ,  第" + 0 + "页    ";
    } else {
        var con = "共" + totalPage + "页 ,  第" + pageNum + "页    ";
    }

    if (pageNum != 1) {
        con = con + "<a href='" + jspname + "?pn=1'>首页 </a>";
    }

    if (pageNum > 1) {
        con = con + "<a href='" + jspname + "?pn=" + (pageNum - 1) + "'>上一页 </a>";
    }


    var num = 3;//要摆出来的页面个数
    // 总共还不超过3页 ,那么页码数只能是有多少页面,就显示多少
    if (totalPage <= num) {
        for (var i = 1; i <= totalPage; i++) {
            con = con + " <a href='" + jspname + "?pn=" + i + "'>" + i + "</a> ";
        }
    } else if (pageNum <= (num - 1)) { // 如果当前页是前 num-1 页面 就显示 123
        con = con + " <a href='" + jspname + "?pn=1'>1</a> ";
        con = con + " <a href='" + jspname + "?pn=2'>2</a> ";
        con = con + " <a href='" + jspname + "?pn=3'>3</a> ";
    } else if (pageNum >= num) { // 9  8 9 10   10   8 9 10
        if (pageNum == (totalPage)) { //最后一页时,也显示最后的三页
            con = con + " <a href='" + jspname + "?pn=" + (totalPage - 2) + "'>" + (totalPage - 2) + "</a> ";
            con = con + " <a href='" + jspname + "?pn=" + (totalPage - 1) + "'>" + (totalPage - 1) + "</a> ";
            con = con + " <a href='" + jspname + "?pn=" + (totalPage) + "'>" + (totalPage) + "</a> ";
        } else { //正常情况
            con = con + " <a href='" + jspname + "?pn=" + (pageNum - 1) + "'>" + (pageNum - 1) + "</a> ";
            con = con + " <a href='" + jspname + "?pn=" + (pageNum) + "'>" + (pageNum) + "</a> ";
            con = con + " <a href='" + jspname + "?pn=" + (pageNum + 1) + "'>" + (pageNum + 1) + "</a> ";
        }
    }

    if (totalPage != pageNum && totalPage != 0) {
        con = con + "<a href='" + jspname + "?pn=" + (pageNum + 1) + "'>下一页 </a>";
        con = con + "<a href='" + jspname + "?pn=" + totalPage + "'>尾页 </a>";
    }
    $("#pageDivId").html(con);  //写到页面上
}