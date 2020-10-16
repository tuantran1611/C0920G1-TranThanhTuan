class Customer {
    constructor(name,id, phone, email, address) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
    getName(){
        return this.name;
    }
    getId(){
        return this.id;
    }
    getEmail(){
        return this.email;
    }
    getAddress(){
        return this.address;
    }
    getPhone(){
        return this.phone;
    }
    setName(name){
        this.name = name;
    }
    setId(id){
        this.id = id;
    }
    setEmail(email){
        this.email = email;
    }
    setAddress(address){
        this.address = address;
    }
    setPhone(phone){
        this.phone = phone;
    }
}