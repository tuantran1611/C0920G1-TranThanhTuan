
function submitRegist() {
    let memName = document.getElementById("memberName").value;
    let memId = document.getElementById("memberId").value;
    let memBirthDay = document.getElementById("memberBirthDay").value;
    let memEmail = document.getElementById("memberEmail").value;
    let memAddress = document.getElementById("memberAddress").value;
    let customerType = document.getElementById("selectCustomerType").value;
    let memDiscount = document.getElementById("memberDiscount").value;
    let memAmount = document.getElementById("memberAmount").value;
    let memRentDay = document.getElementById("memberRentDays").value;
    let serviceType = document.getElementById("selectServiceType").value;
    let roomType = document.getElementById("selectRoomType").value;
    let rentDay = parseInt(memRentDay);
    let discount = parseInt(memDiscount);
    let total;
    switch (serviceType) {
        case "Villa":
            total = 500 * rentDay * (1 - discount/100);
            break;
        case "House":
            total = 300 * rentDay * (1 - discount/100);
            break;
        case "Room":
            total = 100 * rentDay * (1 - discount/100);
            break;
    }
    document.write("Họ và tên: "+ memName);
    document.write("<br/>");
    document.write("Số CMND: "+ memId);
    document.write("<br/>");
    document.write("Ngày sinh: "+ memBirthDay);
    document.write("<br/>");
    document.write("Email: "+ memEmail);
    document.write("<br/>");
    document.write("Địa chỉ: "+ memAddress);
    document.write("<br/>");
    document.write("Customer Type: "+ customerType);
    document.write("<br/>");
    document.write("Giảm giá: "+ memDiscount + "%");
    document.write("<br/>");
    document.write("Số lượng kèm theo: "+ memAmount);
    document.write("<br/>");
    document.write("Số ngày thuê: "+ memRentDay);
    document.write("<br/>");
    document.write("Loại dịch vụ: "+ serviceType);
    document.write("<br/>");
    document.write("Loại phòng : "+ roomType);
    document.write("<br/>");
    document.write("Giá tiền là: " + total + "$");
}