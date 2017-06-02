
package com.od;
import java.sql.Date;
import java.util.List;

public class GetDatesModel {
	
	public Date checkIn;
	public Date checkOut ;
    public Date date;
	
	public GetDatesModel(Date checkIn, Date checkOut, Date date ) {
		super();
		this.checkIn= checkIn;
		this.checkOut= checkOut ;
        this.date=date;
	}
		

 
		public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



		public Date getCheckIn() {
		return checkIn;
	}



	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}



	public Date getCheckOut() {
		return checkOut;
	}



	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}



		public GetDatesModel(){
			
		}

}
