package fscore2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
	private List<ScoreVO> list=new ArrayList<ScoreVO>();
	private String pathname="score2.txt";
	
	public ScoreImpl() {
		loadFile();
	}
	
	private void loadFile() {
		File f=new File(pathname);
		
		if(! f.exists()) { // ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			return;
		}
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(f))) {
			while(true) {
				ScoreVO vo=new ScoreVO();
				vo.setHak(dis.readUTF());
				vo.setName(dis.readUTF());
				vo.setKor(dis.readInt());
				vo.setEng(dis.readInt());
				vo.setMat(dis.readInt());
				
				list.add(vo);
			}
		} catch (EOFException e) {
			//end of file exception
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void insertScore(ScoreVO vo) throws DuplicationException {
		if(readScore(vo.getHak())!=null)
			throw new DuplicationException("ï¿½Ð¹ï¿½ ï¿½ßºï¿½ ï¿½ï¿½ï¿½ï¿½ !!!");
		
		list.add(vo);
	}

	@Override
	public boolean deleteScore(String hak) {
		ScoreVO vo=readScore(hak);
		if(vo==null)
			return false;
		
		list.remove(vo);
		
		return true;
	}

	@Override
	public List<ScoreVO> listScore() {
		return list;
	}

	@Override
	public ScoreVO readScore(String hak) {
		ScoreVO vo=null;
		for(ScoreVO vv:list) {
			if(vv.getHak().equals(hak)) {
				vo=vv;
				break;
			}
		}
		return vo;
	}

	@Override
	public void saveFile() {
		File f=new File(pathname);
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
			
			for(ScoreVO vo:list) {
			dos.writeUTF(vo.getHak());
			dos.writeUTF(vo.getName());
			dos.writeInt(vo.getKor());
			dos.writeInt(vo.getEng());
			dos.writeInt(vo.getMat());
			dos.writeInt(vo.getTot());
			dos.writeInt(vo.getAve());
			}
			System.out.println("ÆÄÀÏ ÀúÀå ¿Ï·á");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
