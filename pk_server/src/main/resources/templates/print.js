function writeHtml(obj) {
    var objStr = JSON.stringify(obj, null, 4);
    var html = objStr.replace(/\n/g, '<br>').replace(/\s/g, '&nbsp');
    document.write(html);
    //document.getElementById("result").innerHTML=html;
}

