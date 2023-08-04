package br.board.model.vo;

public class BRBoard {
	private int boardNo;
	private String boardSubject;
	private String boardContent;
	private String boardDate;
	private String boardWriter;
	
	/*
	 * CREATE TABLE BR_CUSOMOR_BOARD_TBL (
    CUSOMOR_BOARD_NO NUMBER PRIMARY KEY,
    CUSOMOR_BOARD_SUBJECT VARCHAR2(100) NOT NULL,
    CUSOMOR_BOARD_CONTENT VARCHAR2(1500) NOT NULL,
    CUSOMOR_BOARD_DATE TIMESTAMP DEFAULT SYSTIMESTAMP,
    CUSOMOR_BOARD_WRITER VARCHAR2(20) NOT NULL
);
	 */
	
	
	
	
	
	
	public BRBoard() {
		super();
	}
	
	public BRBoard(String boardSubject, String boardContent, String boardWriter) {
		super();
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}



	
	
	
}

