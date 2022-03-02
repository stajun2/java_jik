package kr.green.spring.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	private int fi_num;
	private String fi_ori_name;
	private String fi_name;
	private Integer fi_bd_num;
	private String fi_del;
	private Date fi_del_date;
	
	public FileVO(String fi_ori_name, String fi_name, Integer fi_bd_num) {
		this.fi_ori_name = fi_ori_name;
		this.fi_name = fi_name;
		this.fi_bd_num = fi_bd_num;
	}
}
