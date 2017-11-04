#include <stdio.h>
#include <iostream>
using namespace std;

char * mask;
char * map;

void showMap(int w, int h)
{
   for(int i = 0; i < h; i++){
       for(int j = 0; j < w; j++){
	if(mask[i*w+j])
         cout << (map[i*w+j]==0 ?"@" : (map[i*w+j]>0?("0"+map[i*w+j]):"$"));
      else cout << "#";
       }
      cout << endl;
   }
}

void unmap(int x, int y, int h, int w){
    if(x < 0 || y < 0 || x >= w || y >= h) return;
    if(mask[y*w+x] || map[y*w+x]) return;
    mask[y*w+x] = 1;
    unmap(x-1, y, h, w);
    unmap(x+1, y, h, w);
    unmap(x, y-1, h, w);
    unmap(x, y+1, h, w);
}

void add(int x, int y, int w, int h){
}


int main(){
   int w, h, c;
   cin >> w >> h >> c;
    printf("%d %d\n", w, h);
   map = new char[w*h];
   mask = new char[w*h];

     for(int i = 0; i < c; i++){
         map[3*i+9] = -1;
     }
	int inputX, inputY;
    for(;;){
         cin >> inputX >> inputY;
         if(map[inputX+inputY*w] == -1){cout<<"Die"<<endl;return 0;}
         unmap(inputX, inputY, h, w);
         showMap(w, h);
    }
}
