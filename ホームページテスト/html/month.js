var dt;
changeTime();
var dayOfWeek = dt.getDay();
var dayOfWeekStr = ["日","月","火","水","木","金","土"][dayOfWeek];

//リフレッシュ用
function changeTime(){
  // dtの基準時間のリフレッシュ
  dt = new Date();
  //描写の変更
  changeDisplayTime();
}
setInterval("changeTime()",1000);

//更新用
function changeDisplayTime(){
  var hours = dt.getHours();
  var minutes = dt.getMinutes();
  var seconds = dt.getSeconds();
  if(hours < 10){
    hours = "0" + hours;
  }
  if(minutes < 10){
    minutes = "0" + minutes;
  }
  if(seconds < 10){
    seconds = "0" + seconds;
  }
  document.getElementById("currentTime").innerHTML = hours + " : " + minutes + " : " + seconds;
  console.log(hours + " : " + minutes + " : " + seconds);
}

function createData(){
  document.getElementById("day").innerText = dt.getDate();
  document.getElementById("dow").innerText = dayOfWeekStr;
}

function createIn(){
  document.getElementById("in").innerText = dt.getHours() + " : " + dt.getMinutes();
}

function createOut(){
  document.getElementById("out").innerText = dt.getHours() + " : " + dt.getMinutes();
}

function addCol(){
  var table = document.getElementById("table");
  var row = table.insertRow(-1);
  var cell1 = row.insertCell(-1);
  var cell2 = row.insertCell(-1);
  var cell3 = row.insertCell(-1);
  var cell4 = row.insertCell(-1);
  var cell5 = row.insertCell(-1);
  var cell6 = row.insertCell(-1);
  var cell7 = row.insertCell(-1);
  var cell8 = row.insertCell(-1);
  var cell9 = row.insertCell(-1);
  var cell10 = row.insertCell(-1);
  var cell11 = row.insertCell(-1);
  var cell12 = row.insertCell(-1);
  var cell13 = row.insertCell(-1);
  var cell14 = row.insertCell(-1);
  cell1.innerHTML = '<th scope="col" id="day"><input type="button" value="+" onclick="createData();"></input></th>';
  cell2.innerHTML = '<th scope="col" id="dow"></th>';
  cell3.innerHTML = '<th scope="col"><select name="state"><option value=1>出勤</option><option value=2>欠勤</option><option value=3>遅刻</option><option value=4>早退</option></select></th>';
  cell4.innerHTML = '<th scope="col" id="in"><input type="button" value="始業" onclick="createIn();"></input></th>';
  cell5.innerHTML = '<th scope="col" id="out"><input type="button" value="終業" onclick="createOut();"></input></th>';
  cell6.innerHTML = '-';
  cell7.innerHTML = '-';
  cell8.innerHTML = '-';
  cell9.innerHTML = '-';
  cell10.innerHTML = '-';
  cell11.innerHTML = '-';
  cell12.innerHTML = '-';
  cell13  .innerHTML = '-';
  cell14.innerHTML = '<th scope="col"><input type="submit" value="更新"></input></th>';
}
