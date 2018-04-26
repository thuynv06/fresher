export class Course{
  idCourse: number;
  name: String;
  price: number;

  constructor (idCourse : number, name: String, price :number){
    this.idCourse= idCourse;
    this.name = name;
    this.price = price;
  }
}
