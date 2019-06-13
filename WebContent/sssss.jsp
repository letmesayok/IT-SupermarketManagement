<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
//弹出对话框并输出一段提示信息  
function ale() {  
    //弹出一个对话框  
    alert("提示信息！");  

}  

//弹出一个询问框，有确定和取消按钮  
function firm() {  
    //利用对话框返回的值 （true 或者 false）  
    if (confirm("你确定提交吗？")) {  
        alert("点击了确定");  
    }  
    else {  
        alert("点击了取消");  
    }  

}  

//弹出一个输入框，输入一段文字，可以提交  
function prom() {  
    var name = prompt("请输入您的名字", ""); //将输入的内容赋给变量 name ，  

    //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值  
    if (name)//如果返回的有内容  
    {  
        alert("欢迎您：" + name)  
    }  

}  
</script>
 <input type="button" name="btn2" id="btn2" value="删除" onclick="return confirm('Yes/No')"></input>
 <br>
 <br>
  <a href ="Index.jsp"><input type="button" name="btn2" id="btn2" value="提示" onclick="javaScript:alert('您确定要删除吗？');"></input></a>
  <br>
<input type="submit" value="Sumit" name="Su1" onclick="diag()" />
</p>