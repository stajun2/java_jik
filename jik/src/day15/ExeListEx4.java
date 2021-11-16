package day15;

import java.util.*;

public class ExeListEx4 {

	public static void main(String[] args) {
		/* 오늘의 할일을 5개 입력받아 출력하는 코드를 작성하세요. 단, 리스트를 이용 
		 * 방법1. 오늘의 할일을 String으로 관리하는 방법 
		 * 방법2. 오늘의 할일을 ToDo로 관리하는 방법 */
		//방법2
		ArrayList<ExeToDo> todoList = new ArrayList<ExeToDo>();
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i<5; i++) {
			System.out.print("시간 : ");
			String time = scan.nextLine();
			System.out.print("할일 : ");
			String todo = scan.nextLine();
			//ExeToDo todoObj = new ExeToDo(time, todo);
			//todoList.add(todoObj);
			todoList.add(new ExeToDo(time, todo));
		}
		
		System.out.println(todoList);
		
		scan.close();
	}
}
class ExeToDo{
	String time;
	String todo;
	
	public ExeToDo(String time, String todo) {
		this.time = time;	this.todo = todo;
	}

	@Override
	public String toString() {
		return "\n할일 [시간 : " + time + ", 내용 : " + todo + "]\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExeToDo other = (ExeToDo) obj;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (todo == null) {
			if (other.todo != null)
				return false;
		} else if (!todo.equals(other.todo))
			return false;
		return true;
	}
	
	
}



