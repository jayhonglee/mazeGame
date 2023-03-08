package game;
import java.awt.Image;

/*https://www.bing.com/images/search?view=detailV2&ccid=8ONaPRIK&id=9E904C9F463EEF473A7B9C95F3D877F5567EFDDC&thid=
 * OIP.8ONaPRIKofHQ3QxjHeCmyQAAAA&mediaurl=https%3A%2F%2Fimages-wixmp-ed30a86b8c4ca887773594c2.wixmp.com%
 * 2Ff%2F18527ba2-6cdb-42e8-b5bf-1a43b8ea5bd3%2Fdd9i6k4-95077db9-9438-4da8-8b21-2ff540aca1bf.png%2Fv1%2Ffit%2Fw_150%
 * 2Ch_150%2Cstrp%2Ftactimon_sprite_by_hamurand22_dd9i6k4-150.png%3Ftoken%3DeyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.ey
 * JzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MT
 * VlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NDg4IiwicGF0aCI6IlwvZlwvMTg1MjdiYTItNmNkYi00MmU4LWI1YmYtMWE0M2I4ZWE1YmQzXC9kZ
 * DlpNms0LTk1MDc3ZGI5LTk0MzgtNGRhOC04YjIxLTJmZjU0MGFjYTFiZi5wbmciLCJ3aWR0aCI6Ijw9NDMyIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdl
 * Lm9wZXJhdGlvbnMiXX0.LDyhJdjNSdO95_XKO-a1P-ZLv1ZOkoXLMUyesm3asRo&exph=150&expw=132&q=2d+hero&simid=607995712627485509&form=IRPR
 * ST&ck=138EC4C6E0F72CB1D5C9EDF49F5F70CA&selectedindex=2&ajaxhist=0&ajaxserp=0&vt=0&sim=11&iss=VSI&cdnurl=https%3A%2F%2Fth.bing.co
 * m%2Fth%2Fid%2FR.f0e35a3d120aa1f1d0dd0c631de0a6c9%3Frik%3D3P1%252bVvV32POVnA%26pid%3DImgRaw%26r%3D0&pivotparams=insightsToken%3Dcci
 * d_YMTPuvqh*cp_48570C7B788D3DF7FD1795BC9EB32C51*mid_5FB80BE1EA7A4E013D8CD0769A4234E599DA5C9C*simid_607991945943396471*thid_OIP.YMTP
 * uvqhNxMF8fbuG6BPMAAAAA&ajaxhist=0&ajaxserp=0**/

public class demon extends gameObj {
	boolean up=false;
	boolean down=false;
	boolean left=false;
	boolean right=false;
	public demon(int x, int y, Image ig) {
		super(x, y, ig);
		}
	public demon(int x,int y, int w, int h, Image ig) {
		super(x, y, w, h, ig);
		}
	public void update() {
		if(up) {
			y-=10;
		}
		else if(down) {
			y+=10;
		}
		else if(left) {
			x-=10;
		}
		else if(right) {
			x+=10;
		}
	}
	public void move(int kc) {
		if(kc==87) {
			up=true;
		}
		else if(kc==83) {
			down=true;
		}
		else if(kc==65) {
			left=true;
		}
		else if(kc==68) {
			right=true;
		}
	}
	public void release(int kc) {
		if(kc==87) {
			up=false;
		}
		else if(kc==83) {
			down=false;
		}
		else if(kc==65) {
			left=false;
		}
		else if(kc==68) {
			right=false;
		}
	}	

}