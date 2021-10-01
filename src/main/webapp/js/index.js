var student = {
    name: "John Doe",
    age: 19,
    setName: function(newName){
        this.name = newName;

    },
    printName: function(){
       document.getElementById("printStudentName").innerHTML = this.name + " is " + this.gender;

    },
    address: {
        location: "Loitotok",
        postalAddress: "P.O BOX 23232",
        phoneNumber: "0700 000 000",
        printAddress: function(){
            document.getElementById("printStudentAddress").innerHTML = this.location + ", " + this.postalAddress;
        }
    }
};

student.gender = "Male";

student.printAge = function(){
    document.getElementById("printStudentAge").innerHTML = "<br/> The age of " + this.name + " is " + this.age;
}

student.setName("Jane Doe");
student.printName();
student.printAge();
student.address.printAddress();