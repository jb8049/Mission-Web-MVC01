package kr.ac.kopo.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;

public class BoardDAO {

	public List<BoardVO> selectAll(){
		
		List<BoardVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
	 	sql.append(" select no,title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
	 	sql.append(" from t_board ");
	 	sql.append(" order by no desc ");

	 	// try문에 들어오는 것과 안들어오는 것 차이 정확히 뭐임? auto closable
		try(
				Connection conn =new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				int no = rs.getInt("no");
		 		String title = rs.getString("title"); 
		 		String writer = rs.getString("writer");
		 		String regDate = rs.getString("reg_date");
		 		
		 		BoardVO board = new BoardVO();
		 		board.setNo(no);
		 		board.setTitle(title);
		 		board.setWriter(writer);
		 		board.setRegDate(regDate);
				
				list.add(board);
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return list;
}
	//상세 게시물 조회
	public BoardVO selectByNo(int boardNo) {
		
		BoardVO board = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt ");
		sql.append("      , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_board ");
		sql.append(" where no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	
	//게시글 등록 (로그인하지 않고 게시글 등록이 가능한 것)
	
	public void insert(BoardVO board) {   

		StringBuilder sql = new StringBuilder();

		sql.append(" insert into t_board(no, title, writer, content) ");
		sql.append(" values(?, ?, ?, ?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			int loc = 1;
			
			pstmt.setInt(loc++, board.getNo());
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());
			pstmt.setString(loc++, board.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
	
	//게시판 최신 NO 추출
	public int selectNo() {
		
		int no = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select seq_t_board_no.nextval from dual ");
		// seq_t_board_no는 게시물의 pk, nextval을 통해 새로운 게시물 번호를 불러옴
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				) {
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					no = rs.getInt(1);  // 컬럼한 개 뿐이니까
					
				}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return no;
		
	}
	
	
	
	
	
}
