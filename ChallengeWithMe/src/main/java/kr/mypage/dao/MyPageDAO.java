package kr.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.badge.vo.BadgeVO;
import kr.score.dao.ScoreDAO;
import kr.score.vo.ScoreVO;
import kr.util.DBUtil;
import kr.xuser.vo.XuserVO;

public class MyPageDAO {
	// 싱글턴 패턴
		private static MyPageDAO instance = new MyPageDAO();
		
		public static MyPageDAO getInstance() {
			return instance;
		}
		private MyPageDAO() {};
		
	// 마이페이지 상세정보
	public XuserVO getMyInfo(long us_num)throws Exception{
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    XuserVO xuser = null;
	    String sql = null;
	    
	    try {
	        con = DBUtil.getConnection();
	        sql = "SELECT * FROM xuser JOIN user_detail USING(us_num) WHERE us_num=?";
	        
	        ps = con.prepareStatement(sql);
	        ps.setLong(1, us_num);
	        
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            xuser = new XuserVO();
	            xuser.setUs_num(rs.getLong("us_num"));
	            xuser.setId(rs.getString("us_id"));
	            xuser.setRank(rs.getInt("us_rank"));
	            xuser.setBan(rs.getInt("us_ban"));
	            xuser.setWallet(rs.getString("us_wallet"));
	            xuser.setBirth(rs.getString("us_birth"));
	            xuser.setGen(rs.getInt("us_gen"));
	            xuser.setTel(rs.getString("us_tel"));
	            xuser.setPasswd(rs.getString("us_pw"));
	            xuser.setNickname(rs.getString("us_nickname"));
	            xuser.setDate(rs.getString("us_date"));
	            xuser.setRdate(rs.getString("us_rdate"));
	            xuser.setImg(rs.getString("us_img"));
	            xuser.setEmail(rs.getString("us_email"));
	            xuser.setName(rs.getString("us_name"));
	            xuser.setZipcode(rs.getString("us_zipcode"));
	            xuser.setAddress1(rs.getString("us_address1"));
	            xuser.setAddress2(rs.getString("us_address2"));
	            xuser.setAlarm(rs.getInt("us_alarm"));
	            xuser.setAdmin(rs.getInt("admin"));
	        }
	    } catch (Exception e) {
	        throw new Exception(e);
	    } finally {
	        DBUtil.executeClose(rs, ps, con);
	    }
	    return xuser;
	}
	
	// 마이페이지 선호 카테고리
	public List<String> pref(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "select c.cate_name  from pref p join cate c on p.cate_num = c.cate_num WHERE p.us_num = ? ORDER BY uscat_date desc";
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			
			rs = ps.executeQuery();
			list = new ArrayList<String>();
			
			while(rs.next()) {
				String prefName = rs.getString("cate_name");
				list.add(prefName);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return list;
	}
	
	// 유저 획득 뱃지 개수 정보 불러오기
	public List<Integer> getBadgeInfo(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Integer> list = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "select b.totalbg, coalesce(ub.us_bgcount, 0) as us_bg, b.totalbg - coalesce(ub.us_bgcount, 0) as re_bg "
					+ "from (select count(*) as totalbg from badge) b "
					+ "left join (select count(DISTINCT bg_num) as us_bgcount from userbadge where us_num = ?) ub on 1 = 1";
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			
			rs = ps.executeQuery();
			list = new ArrayList<Integer>();
			while(rs.next()) {
				int totalbg = rs.getInt(1);
				int us_bg = rs.getInt(2);
				int re_bg = rs.getInt(3);
				list.add(totalbg);
				list.add(us_bg);
				list.add(re_bg);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return list;
	}
	
	// 프로필 사진 수정
	public void updateImg(String img, long us_num)throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "UPDATE user_detail SET us_img=? WHERE us_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, img);
			ps.setLong(2, us_num);
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 개인정보 수정
	public void updateXuser(XuserVO xuser)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "UPDATE user_detail SET us_nickname=?, us_email=?, us_birth=?, us_tel=?, us_gen=?, "
					+ "us_zipcode=?, us_address1=?, us_address2=?, us_rdate=SYSDATE WHERE us_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, xuser.getNickname());
			ps.setString(2, xuser.getEmail());
			ps.setString(3, xuser.getBirth());
			ps.setString(4, xuser.getTel());
			ps.setInt(5, xuser.getGen());
			ps.setString(6, xuser.getZipcode());
			ps.setString(7, xuser.getAddress1());
			ps.setString(8, xuser.getAddress2());
			ps.setLong(9, xuser.getUs_num());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 비밀번호 수정
	public void updatePwd(String pwd, long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "UPDATE user_detail SET us_pw=? WHERE us_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setLong(2, us_num);
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 회원탈퇴
	public void deleteUser(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			
			sql = "UPDATE xuser SET us_ban=2 WHERE us_num=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			ps.executeUpdate();
			
			sql = "DELETE FROM user_detail WHERE us_num=?";
			ps2 = con.prepareStatement(sql);
			ps2.setLong(1, us_num);
			ps2.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps2, null);
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 좋아요 챌린지 목록
	public List<String> selectChallLike(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "SELECT c.ch_title FROM chall c "
					+ "JOIN chall_like l ON c.ch_num = l.ch_num WHERE l.us_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			
			rs = ps.executeQuery();
			list = new ArrayList<String>();
			while(rs.next()) {
				String like = rs.getString(1);
				list.add(like);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return list;
	}
	
	// 알람 여부 변경
	public void updateAlarm(long us_num, int us_alarm)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "UPDATE user_detail SET us_alarm=? WHERE us_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, us_alarm);
			ps.setLong(2, us_num);
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 좋아요 챌린지
	public List<Long> getLikeChallNum(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Long> list = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "SELECT ch_num FROM chall_like WHERE us_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			
			rs = ps.executeQuery();
			list = new ArrayList<Long>();
			while(rs.next()) {
				Long ch_num = rs.getLong(1);
				list.add(ch_num);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return list;
	}
	
	// 선호카테고리 변경
	public void updatePref(String pref, long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String sql = null;
		
		String[] idArray = pref.split(",");
		
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			sql = "DELETE FROM PREF WHERE us_num=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			ps.executeUpdate();
			
			sql = "INSERT INTO pref (uscat_date, us_num, cate_num) "
					+ "VALUES(SYSDATE, ?, ?)";
			ps2 = con.prepareStatement(sql);
			for(int i = 0; i < idArray.length; i++) {
				ps2.setLong(1, us_num);
				ps2.setLong(2, Long.parseLong(idArray[i]));
				ps2.addBatch();
			}
			ps2.executeBatch();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps2, null);
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 달성률 이미지
	public int getAchiev(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		int num = 0;
		
		ScoreDAO dao = ScoreDAO.getInstance();
		ScoreVO db_score = dao.getScoreInfo(us_num);
		dao.updateScoreInfo(db_score);
		int score = dao.calculateScore(db_score);
		if(score >= 0 && score <= 99) {
			num = 1;
		}else if(score >= 100 && score <= 499) {
			num = 2;
		}else if(score >= 500 && score <= 999) {
			num = 3;
		}else if(score >= 1000 && score <= 1499) {
			num = 4;
		}else if(score >= 1500 && score <= 2499) {
			num = 5;
		}else if(score >= 2500 && score <= 3999) {
			num = 6;
		}else if(score >= 4000 && score <= 5499) {
			num = 7;
		}else if(score >= 5500 && score <= 6999) {
			num = 8;
		}else if(score >= 7000 && score <= 8999) {
			num = 9;
		}else if(score >= 9000){
			num = 10;
		}
		
		try {
			con = DBUtil.getConnection();
			sql = "UPDATE xuser SET us_rank=? WHERE us_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			ps.setInt(2, num);
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception();
		}finally {
			DBUtil.executeClose(null, ps, con);
		}
		return num;
	}
	
	// 나의 챌린지 각종 정보
	public List<Integer> getChall(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Integer> list = null;
		String sql = null;
		
		
		try {
			con = DBUtil.getConnection();
			sql = "SELECT (SELECT COUNT(*) FROM chall WHERE us_num = ?) as chall,"
					+ " (SELECT COUNT(*) FROM participant WHERE us_num = ? AND p_stat = 'finished') as finished,"
					+ " (SELECT COUNT(*) FROM participant WHERE us_num = ?) as total"
					+ " FROM dual";
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			ps.setLong(2, us_num);
			ps.setLong(3, us_num);
			
			rs = ps.executeQuery();
			list = new ArrayList<Integer>();
			while(rs.next()) {
				int chall = rs.getInt(1);
				int finish = rs.getInt(2);
				int total = rs.getInt(3);
				list.add(chall);
				list.add(finish);
				list.add(total);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return list;
	}
	
	// 관리자 뱃지 등록
	public void insertBadge(BadgeVO badge)throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "INSERT INTO badge (bg_num, bg_img, bg_name, bg_desc) VALUES(badge_seq.nextval, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, badge.getBg_img());
			ps.setString(2, badge.getBg_name());
			ps.setString(3, badge.getBg_desc());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 뱃지 리스트
	public List<BadgeVO> selectBadge()throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BadgeVO> list = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "SELECT * FROM badge";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			list = new ArrayList<BadgeVO>();
			while(rs.next()) {
				BadgeVO badge = new BadgeVO();
				badge.setBg_num(rs.getLong("bg_num"));
				badge.setBg_img(rs.getString("bg_img"));
				badge.setBg_name(rs.getString("bg_name"));
				badge.setBg_desc(rs.getString("bg_desc"));
				list.add(badge);
			}
			
		}catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return list;
	}
	
	// 수정 뱃지 정보
	public BadgeVO modifyBadge(long bg_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BadgeVO badge = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "SELECT * FROM badge WHERE bg_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, bg_num);
			rs = ps.executeQuery();
			if(rs.next()) {
				badge = new BadgeVO();
				badge.setBg_num(rs.getLong("bg_num"));
				badge.setBg_img(rs.getString("bg_img"));
				badge.setBg_name(rs.getString("bg_name"));
				badge.setBg_desc(rs.getString("bg_desc"));
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return badge;
	}
	
	// 뱃지 정보 수정
	public void updateBadge(BadgeVO badge, long bg_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "UPDATE badge SET bg_img=?, bg_name=?, bg_desc=? WHERE bg_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, badge.getBg_img());
			ps.setString(2, badge.getBg_name());
			ps.setString(3, badge.getBg_desc());
			ps.setLong(4, bg_num);
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
	}
	
	// 유저 획득 뱃지 번호 가져오기
	public List<Long> getUserbadge(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Long> list = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			sql = "SELECT * FROM userbadge WHERE us_num=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			
			rs = ps.executeQuery();
			list = new ArrayList<Long>();
			while(rs.next()) {
				long bg_num = rs.getLong("bg_num");
				list.add(bg_num);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, ps, con);
		}
		return list;
	}
	
	// 대표 뱃지 가져오기
	public String getMainBadge(long us_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		String bg_img = "";
		
		try {
			con = DBUtil.getConnection();
			sql = "SELECT bg_img FROM badge WHERE bg_num=(SELECT bg_num FROM userbadge WHERE us_num=? AND bg_main=1)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				bg_img = rs.getString(1);
			}
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
		return bg_img;
	}
	
	// 대표 뱃지 설정
	public void setMainBadge(long us_num, long bg_num)throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String sql = null;
		
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			
			sql = "UPDATE userbadge SET bg_main=0 WHERE us_num=? AND bg_main=1";
			ps = con.prepareStatement(sql);
			ps.setLong(1, us_num);
			ps.executeUpdate();
			
			sql = "UPDATE userbadge SET bg_main=1 WHERE us_num=? AND bg_num=?";
			ps2 = con.prepareStatement(sql);
			ps2.setLong(1, us_num);
			ps2.setLong(2, bg_num);
			ps2.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, ps, con);
		}
	}
}
