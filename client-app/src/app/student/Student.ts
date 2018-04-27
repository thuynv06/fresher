
export class Student{
  idStudent:number;
  name: string;
  age: number;
  address: string;
  phone: string;

  constructor (idStudent: number, name: string, age: number, address:string,phone:string){
    this.idStudent=idStudent;
    this.name= name;
    this.age= age;
    this.address= address;
    this.phone = phone;
  }
}
