//Nhập dữ liệu
let memName = document.getElementById("memberName");
let memId = document.getElementById("memberId");
let memBirthDay = document.getElementById("memberBirthDay");
let memEmail = document.getElementById("memberEmail");
let memAddress = document.getElementById("memberAddress");
let customerType = document.getElementById("selectCustomerType");
let memDiscount = document.getElementById("memberDiscount");
let memAmount = document.getElementById("memberAmount");
let memRentDay = document.getElementById("memberRentDays");
let serviceType = document.getElementById("selectServiceType");
let roomType = document.getElementById("selectRoomType");
//Dữ liệu xuất
let name1 = document.getElementById("memberName1");
let Id1 = document.getElementById("memberId1");
let birthDay1 = document.getElementById("memberBirthDay1");
let email1 = document.getElementById("memberEmail1");
let address1 = document.getElementById("memberAddress1");
let customerType1 = document.getElementById("memberCustomerType1");
let discount1 = document.getElementById("memberDiscount1");
let amount1 = document.getElementById("memberAmount1");
let rentDay1 = document.getElementById("memberDayRents1");
let serviceType1 = document.getElementById("memberServiceType1");
let roomType1 = document.getElementById("memberRoomType1");
let moneyPay = document.getElementById("moneyPay");
//Định dạng tên khi ấn đăng ký sẽ bỏ phần khoảng trắng thừa
function inputName() {
    let name = "";
    let nameVal = memName.value;
    for (let i = 0;i < nameVal.length; i++){
        if (nameVal.charAt(i) === "" && nameVal.charAt(i) === ""){
            continue;
        }
        name += nameVal.charAt(i);
    }
    name1.innerText = name;
}
//Email nhập vào đúng định dạng rồi mới Đăng ký
function inputEmail() {
    let count2 = 0;
    let count3 = 0;
    let emailVal = memEmail.value;
    for (let i = 0;i < emailVal.length; i++){
        if (emailVal.charAt(i) === "@") {
            count2++;
            for (let j = i+2; j < emailVal.length; j++){
                if (emailVal.charAt(j) === "."){
                    count3++;
                }
            }
        }
    }
    if (count2 !== 1 || count3 < 1){
        document.getElementById("warningEmail").innerHTML = "Vui lòng nhập đúng định dạng";
    } else {
        document.getElementById("warningEmail").innerHTML = "";
    }
}
function inputId() {
    let idVal = Number.parseFloat(memId.value);
    if (!Number.isInteger(idVal)){
        document.getElementById("warningId").innerHTML = "Vui lòng nhập đúng định dạng";
    } else if (idVal<100000000 || idVal>999999999) {
        document.getElementById("warningId").innerHTML = "Vui lòng nhập đúng định dạng";
    } else {
        document.getElementById("warningId").innerHTML = "";
    }
}
//Số lượng đi kèm và số ngày thuê là số nguyên dương
function inputAmount() {
    let amountVal = parseInt(memAmount.value);
    if (amountVal < 1){
        document.getElementById("warningAmount").innerHTML = "Vui lòng nhập đúng số người đi kèm";
    } else {
        document.getElementById("warningAmount").innerHTML = "";
    }
}
//Số lượng đi kèm và số ngày thuê là số nguyên dương
function inputRentDay() {
    let rentDayVal = parseInt(memRentDay.value);
    if (rentDayVal < 1){
        document.getElementById("warningRentDay").innerHTML = "Vui lòng nhập đúng số ngày";
    } else {
        document.getElementById("warningRentDay").innerHTML = "";
    }
}
//Hiển thị thông tin khi ấn Đăng Ký
function submitRegist() {
    document.getElementById("show").style.display = "none";
    document.getElementById("edit").style.display = "block";
    //Giảm giá theo địa chỉ
    let sAdd;
    switch (memAddress.value) {
        case "Đà Nẵng":
            sAdd = 20;
            break;
        case "Huế":
            sAdd = 10;
            break;
        case "Quảng Nam":
            sAdd = 5;
            break;
    }
    //Giảm theo thời gian lưu trú
    let sRentDay;
    switch ((parseInt(memRentDay.value) >= 7) ? 1
        : (parseInt(memRentDay.value) >= 5) && (parseInt(memRentDay.value) < 7) ? 2
            : (parseInt(memRentDay.value) >= 2) ? 3
                : 4) {
        case 1:
            sRentDay = 30;
            break;
        case 2:
            sRentDay = 20;
            break;
        case 3:
            sRentDay = 10;
            break;
        case 4:
            sRentDay = 0;
            break;
    }
    //Giảm theo Customer Type
    let sCusType;
    switch (customerType.value) {
        case "Diamond":
            sCusType = 15;
            break;
        case "Platinum":
            sCusType = 10;
            break;
        case "Gold":
            sCusType = 5;
            break;
        case "Silver":
            sCusType = 2;
            break;
        case "Member":
            sCusType = 0;
            break;
    }
    inputName();
    memDiscount.value = sAdd + sRentDay + sCusType;
    Id1.innerText = memId.value;
    birthDay1.innerText = memBirthDay.value;
    address1.innerText = memAddress.value;
    email1.innerText = memEmail.value;
    customerType1.innerText = customerType.value;
    discount1.innerText = memDiscount.value;
    amount1.innerText = memAmount.value;
    rentDay1.innerText = memRentDay.value;
    serviceType1.innerText = serviceType.value;
    roomType1.innerText = roomType.value;
    //Tổng tiền thanh toán
    let total;
    switch (serviceType.value) {
        case "Villa":
            total = 500 * parseInt(memRentDay.value) - sAdd - sRentDay - sCusType;
            break;
        case "House":
            total = 300 * parseInt(memRentDay.value) - sAdd - sRentDay - sCusType;
            break;
        case "Room":
            total = 100 * parseInt(memRentDay.value) - sAdd - sRentDay - sCusType;
            break;
    }
    moneyPay.innerText = total;
}

function submitEdit() {
    document.getElementById("show").style.display = "block";
    document.getElementById("edit").style.display = "none";
}