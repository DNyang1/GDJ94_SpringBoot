package com.winter.app.board;

import com.winter.app.files.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardFileDTO extends FileDTO{

	private Long boardNum;
}
