export class TodoItems {
  private id: number;
  private description: string;
  private location: string;
  private date: Date;

   constructor(description: string, location: string, date:Date){
    this.description = description;
    this.location = location;
    this.date=date;
    
   }
}


