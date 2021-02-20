package fscore3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
	private List<ScoreVO> list=new ArrayList<ScoreVO>();
	private String pathname="score3.txt";
	
	public ScoreImpl() {
		loadFile();
	}
	
	private void loadFile() {
		File f=new File(pathname);
		
		if(! f.exists()) { // ������ ������
			return;
		}
		
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))) {
			while(true) {
				ScoreVO vo=(ScoreVO)ois.readObject();
				list.add(vo);
			}
		} catch (EOFException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void insertScore(ScoreVO vo) throws DuplicationException {
		if(readScore(vo.getHak())!=null)
			throw new DuplicationException("�й� �ߺ� ���� !!!");
		
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
		//ObjectOutputStream�� ������ append�� open�ϸ� �ȵ� - Ŭ�������� ��� ����Ǳ⿡
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f))) {
			for(ScoreVO vo:list){
				oos.writeObject(vo);
				
			}
			System.out.println("���� ���� �Ϸ�");
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
