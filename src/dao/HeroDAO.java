package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Hero;

public class HeroDAO {
	public HeroDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8", "root", "");
	}
	public int getTotal(){
		int total=0;
		try(Connection c=getConnection();Statement s=c.createStatement()) {
			String sql="select count(*) from hero";
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
				total=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}
	public void add(Hero h){
		String sql="insert into hero values(null,?,?,?)";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setString(1, h.name);
			ps.setFloat(2, h.hp);
			ps.setInt(3, h.damage);
			ps.execute();
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				h.id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Hero h){
		String sql="update hero set name=?,hp=?,damage=? where id=?";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setString(1, h.name);
			ps.setFloat(2, h.hp);
			ps.setInt(3, h.damage);
			ps.setInt(4, h.id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id){
		try(Connection c=getConnection();Statement s=c.createStatement()){
			String sql="delete from hero where id="+id;
			s.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Hero get(int id){
		Hero hero=null;
		try(Connection c=getConnection();Statement s=c.createStatement()){
			String sql="select * from hero where id="+id;
			ResultSet rs=s.executeQuery(sql);
			if(rs.next()){
				hero=new Hero();
				hero.id=id;
				hero.name=rs.getString(2);
				hero.hp=rs.getFloat("hp");
				hero.damage=rs.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;
	}
	public List<Hero> list(){
		return list(0,Short.MAX_VALUE);
	}
	public List<Hero> list(int start,int count){
		List<Hero> heros=new ArrayList<Hero>();
		String sql="select * from hero order by id desc limit ?,?";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Hero hero=new Hero();
				hero.id=rs.getInt(1);
				hero.name=rs.getString("name");
				hero.hp=rs.getFloat("hp");
				hero.damage=rs.getInt(4);
				heros.add(hero);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}
}
