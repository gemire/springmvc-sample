// grid.cpp : Defines the entry point for the application.
//

#include "stdafx.h"
#include "grid.h"
#define MAX_LOADSTRING 100
#define CELL_SIZE 30
#define MAIN_WINDOW_WIDTH 800
#define MAIN_WINDOW_HEIGHT 600
#include <stdio.h>
#include "MapQuad.h"
#include "ModelManager.h"
#include "XYTrace.h"
#include <vector>
#include "micropather\micropather.h"
using namespace micropather;

// Global Variables:
HINSTANCE hInst;								// current instance
TCHAR szTitle[MAX_LOADSTRING];					// The title bar text
TCHAR szWindowClass[MAX_LOADSTRING];			// the main window class name
HWND gridhWnd = NULL;
HWND dialogHWnd = NULL;
HWND mainWnd = NULL;
HDC memdc = NULL;
HBITMAP hbit;
HPEN hOldPen = NULL;
HPEN linePen = NULL;
HPEN hgraphPen = NULL;
HBRUSH redBrush = NULL;
HBRUSH greenBrush = NULL;
HBRUSH whiteBrush, yellowBrush,startBrush, endBrush;
int maxX, maxY;
RECT gridRect;
RECT dialogRect;
CModelManager model;
int simulationState = 0; // the step of the simulation that we are in;
vector<void*> solvedPath;
MicroPather* pather = NULL;




LRESULT CALLBACK ToolboxProc(HWND hWndDlg, UINT Msg, WPARAM wParam, LPARAM lParam);
void drawGridToMem();
void drawCell(int cornerX, int cornerY,HBRUSH brush);
void createMapQuads(int width, int height);
void ProcessSelect(int x, int y);
void drawPath(HDC hdc);
void testDraw();
void cleanGrid();

// Forward declarations of functions included in this code module:
ATOM				MyRegisterClass(HINSTANCE hInstance);
BOOL				InitInstance(HINSTANCE, int);
LRESULT CALLBACK	WndProc(HWND, UINT, WPARAM, LPARAM);
LRESULT CALLBACK	About(HWND, UINT, WPARAM, LPARAM);

int APIENTRY _tWinMain(HINSTANCE hInstance,
                     HINSTANCE hPrevInstance,
                     LPTSTR    lpCmdLine,
                     int       nCmdShow)
{
 	// TODO: Place code here.
	MSG msg;
	HACCEL hAccelTable;
	
	// Initialize global strings
	LoadString(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
	LoadString(hInstance, IDC_GRID, szWindowClass, MAX_LOADSTRING);
	MyRegisterClass(hInstance);

	// Perform application initialization:
	if (!InitInstance (hInstance, nCmdShow)) 
	{
		return FALSE;
	}
	cout<< "TEST\n";
	hAccelTable = LoadAccelerators(hInstance, (LPCTSTR)IDC_GRID);

	// Main message loop:
	while (GetMessage(&msg, NULL, 0, 0)) 
	{
		if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg)) 
		{
			TranslateMessage(&msg);
			DispatchMessage(&msg);
		}
	}

	return (int) msg.wParam;
}



//
//  FUNCTION: MyRegisterClass()
//
//  PURPOSE: Registers the window class.
//
//  COMMENTS:
//
//    This function and its usage are only necessary if you want this code
//    to be compatible with Win32 systems prior to the 'RegisterClassEx'
//    function that was added to Windows 95. It is important to call this function
//    so that the application will get 'well formed' small icons associated
//    with it.
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
	WNDCLASSEX wcex;

	wcex.cbSize = sizeof(WNDCLASSEX); 

	wcex.style			= CS_HREDRAW | CS_VREDRAW;
	wcex.lpfnWndProc	= (WNDPROC)WndProc;
	wcex.cbClsExtra		= 0;
	wcex.cbWndExtra		= 0;
	wcex.hInstance		= hInstance;
	wcex.hIcon			= LoadIcon(hInstance, (LPCTSTR)IDI_GRID);
	wcex.hCursor		= LoadCursor(NULL, IDC_ARROW);
//	wcex.hbrBackground	= (HBRUSH)(COLOR_WINDOW+1);
	wcex.hbrBackground	= (HBRUSH) GetStockObject(WHITE_BRUSH);
	wcex.lpszMenuName	= (LPCTSTR)IDC_GRID;
	wcex.lpszClassName	= szWindowClass;
	wcex.hIconSm		= LoadIcon(wcex.hInstance, (LPCTSTR)IDI_SMALL);

	return RegisterClassEx(&wcex);
}

//
//   FUNCTION: InitInstance(HANDLE, int)
//
//   PURPOSE: Saves instance handle and creates main window
//
//   COMMENTS:
//
//        In this function, we save the instance handle in a global variable and
//        create and display the main program window.
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   HWND hWnd;

   hInst = hInstance; // Store instance handle in our global variable   
   
   int width = GetSystemMetrics(SM_CXSCREEN);
   int height = GetSystemMetrics(SM_CYSCREEN);
	maxX = width;
	maxY = height;

	SetTraceFilePrefix(_T("e:\\teaching\\cplusplus\\zz"));
	SetTraceLevel(TraceDebug);


   hWnd = CreateWindow(szWindowClass, szTitle, WS_BORDER | WS_CAPTION | WS_SYSMENU,
      (width -MAIN_WINDOW_WIDTH)/2, (height-MAIN_WINDOW_HEIGHT)/2, MAIN_WINDOW_WIDTH,MAIN_WINDOW_HEIGHT, NULL, NULL, hInstance, NULL);

   if (!hWnd)
   {
      return FALSE;
   }
   mainWnd = hWnd;

 RECT rMain;
 GetClientRect(hWnd,&rMain);

   if (!hWnd)
   {
      return FALSE;
   }



 dialogHWnd = CreateDialog(hInstance,MAKEINTRESOURCE(IDD_MAIN_DIALOG),hWnd,(DLGPROC)ToolboxProc);
 MoveWindow(dialogHWnd,0,0,170,rMain.bottom ,true);
 ShowWindow(dialogHWnd, SW_SHOW);
 RECT rr;
 GetClientRect(dialogHWnd,&rr);

 dialogRect = rr;



gridhWnd =

CreateWindow("STATIC", "", WS_CHILD | WS_VISIBLE ,
      rr.right, 0, rMain.right - rr.right,rMain.bottom, hWnd, NULL, hInstance,NULL );

 GetClientRect(gridhWnd,&gridRect);
 createMapQuads(gridRect.right - gridRect.left,gridRect.bottom - gridRect.top);








   ShowWindow(hWnd, nCmdShow);
   UpdateWindow(hWnd);

   return TRUE;
}

//
//  FUNCTION: WndProc(HWND, unsigned, WORD, LONG)
//
//  PURPOSE:  Processes messages for the main window.
//
//  WM_COMMAND	- process the application menu
//  WM_PAINT	- Paint the main window
//  WM_DESTROY	- post a quit message and return
//
//
LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	int wmId, wmEvent;
	PAINTSTRUCT ps;
	HDC hdc;
	//RECT cRect,gRect;
	//HBRUSH      NewBrush;
	//char str[80];
	WPARAM fwKeys;
	int ctrlvar = -1;
	int dispWidth = dialogRect.right;


	switch (message) 
	{

	case WM_LBUTTONDOWN:
		fwKeys = wParam;        // key flags 
		POINT pt;

		pt.x = LOWORD(lParam);  // horizontal position of cursor 
		pt.y = HIWORD(lParam);  // vertical position of cursor 
		pt.x = pt.x - dispWidth;

		pt.x = pt.x/CELL_SIZE;
		pt.y = pt.y/CELL_SIZE;

		if (fwKeys & MK_CONTROL)
			ctrlvar = 1; // ctrl modifier is down
		else
			ctrlvar = -1;
		//sprintf(str,"(%d,%d)",maxX,maxY);
		//SetDlgItemText(dialogHWnd,IDC_TEXT_DISPLAY,str);
        ProcessSelect(pt.x,pt.y);
		break;



	case WM_COMMAND:
		wmId    = LOWORD(wParam); 
		wmEvent = HIWORD(wParam); 
		// Parse the menu selections:
		switch (wmId)
		{
		case IDM_ABOUT:
			DialogBox(hInst, (LPCTSTR)IDD_ABOUTBOX, hWnd, (DLGPROC)About);
			break;
		case IDM_EXIT:
			DestroyWindow(hWnd);
			break;
		default:
			return DefWindowProc(hWnd, message, wParam, lParam);
		}
		break;
	case WM_PAINT:

		//GetClientRect(hWnd,&cRect);
		//GetClientRect(gridhWnd,&gRect);
		hdc = BeginPaint(hWnd, &ps);
		// TODO: Add any drawing code here...
		 //GetSysColor(COLOR_3DFACE)
		 /*
        NewBrush = CreateSolidBrush(RGB(0,0,200));
        SelectObject(hdc, NewBrush);
		Rectangle(hdc,cRect.left,cRect.top-5,cRect.right,cRect.bottom+5);
        DeleteObject(NewBrush);
	*/
		 
		EndPaint(hWnd, &ps);

		hdc = BeginPaint(gridhWnd, &ps);
		/*
        SetMapMode(hdc, MM_ANISOTROPIC);
        SetWindowExtEx(hdc, 2, 2, NULL);
		SetViewportOrgEx(hdc,-35,-35,NULL);
		*/

		BitBlt(hdc,0,0,maxX,maxY, memdc,0,0,SRCCOPY);
		if (solvedPath.size() != 0)
			drawPath(hdc);
		EndPaint(gridhWnd, &ps);

		break;
	case WM_DESTROY:
		DeleteDC(memdc);
		DeleteObject(hgraphPen);
		DeleteObject(linePen);
		DeleteObject(hbit);
		DeleteObject(greenBrush);
		DeleteObject(yellowBrush);
		DeleteObject(redBrush);
		DeleteObject(whiteBrush);
		DeleteObject(startBrush);
		DeleteObject(endBrush);
		if (pather != NULL)
			delete pather;
		PostQuitMessage(0);
		break;

	case WM_CREATE:
		HDC hdc;
	 	//hdc = GetDC(gridhWnd);
	 	hdc = GetDC(mainWnd);
		hgraphPen = CreatePen(PS_SOLID,1,RGB(0,0,0));
		greenBrush = CreateSolidBrush(RGB(0,200,0));
		yellowBrush = CreateSolidBrush(RGB(200,200,0));
		redBrush = CreateSolidBrush(RGB(200,0,0));
		whiteBrush = CreateSolidBrush(RGB(255,255,255));
		linePen = CreatePen(PS_SOLID,2,RGB(0,255,255));
		startBrush = CreateSolidBrush(RGB(0,0,255));
		endBrush = CreateSolidBrush(RGB(200,0,200));
		memdc = CreateCompatibleDC(hdc);
	 	hbit = CreateCompatibleBitmap(hdc,maxX,maxY);
		drawGridToMem();
		ReleaseDC(gridhWnd,hdc);
		//WriteTrace(TraceDebug,_T("CREATE"));





		break;

	default:
		return DefWindowProc(hWnd, message, wParam, lParam);
	}
	return 0;
}

// Message handler for about box.
LRESULT CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
	switch (message)
	{
	case WM_INITDIALOG:

		return TRUE;

	case WM_COMMAND:
		if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL) 
		{
			EndDialog(hDlg, LOWORD(wParam));
			return TRUE;
		}
		break;
	}
	return FALSE;
}



LRESULT CALLBACK ToolboxProc(HWND hWndDlg, UINT Msg, WPARAM wParam, LPARAM lParam)
{
	
	int wmId, wmEvent;
	HWND hwndCtl = (HWND) lParam;
//	char ff[30];
	LRESULT stepSel;

	switch(Msg)
	{
	case WM_INITDIALOG:
		//SetDlgItemText(hWndDlg,IDC_TEXT_DISPLAY,ff);
		SendDlgItemMessage(hWndDlg, IDC_STEP_LIST,
                     LB_ADDSTRING, 0, (LPARAM)"Create Map");
		SendDlgItemMessage(hWndDlg, IDC_STEP_LIST,
                     LB_ADDSTRING, 0, (LPARAM)"Mark Start");
		SendDlgItemMessage(hWndDlg, IDC_STEP_LIST,
                     LB_ADDSTRING, 0, (LPARAM)"Mark End");
		SendDlgItemMessage(hWndDlg, IDC_STEP_LIST,
                     LB_SETCURSEL, 0,0);


		return TRUE;

	case WM_ENTERIDLE:
		break;


	case WM_COMMAND:
		wmId    = LOWORD(wParam); 
		wmEvent = HIWORD(wParam); // BN_CLICKED

		switch (wmId)
		{
		case IDC_STEP_LIST:
			if (wmEvent = LBN_SELCHANGE)
			{
				stepSel = 
					SendDlgItemMessage(hWndDlg, IDC_STEP_LIST, LB_GETCURSEL, 0, 0);
				//sprintf(ff,"sel is %d",stepSel);
				//SetDlgItemText(hWndDlg,IDC_TEXT_DISPLAY,ff);
				simulationState = (int) stepSel;
			}

			break;
		case IDC_TEST_BUTTON:
			testDraw();
			return TRUE;

		case IDC_RESET:
			cleanGrid();
			return TRUE;
		}
		
	}

	return FALSE;
}



void drawGridToMem()
{
		
		HBRUSH oldBrush;
		HPEN oldPen ;
		SelectObject(memdc, hbit);
		HBRUSH hbrush = (HBRUSH) GetStockObject(WHITE_BRUSH);
		oldBrush = (HBRUSH) SelectObject(memdc,hbrush);
		PatBlt(memdc,0,0,maxX,maxY,PATCOPY);
		oldPen = (HPEN) SelectObject(memdc,hgraphPen);
		MoveToEx(memdc,0,0,NULL);

		for (int i=0;i<maxX+1;i+=CELL_SIZE)
		{
				MoveToEx(memdc,i,0,NULL);
				LineTo(memdc,i,maxY+1);


		}
		for (int j=0;j<maxY+1;j+=CELL_SIZE)
		{
				MoveToEx(memdc,0,j,NULL);
				LineTo(memdc,maxX+1,j);


		}


		SelectObject(memdc,oldPen);
		SelectObject(memdc,oldBrush);
	





}


void drawCell(int rowX, int colY, HBRUSH myBrush)
{
	
	
	HBRUSH hOldBrush = (HBRUSH) SelectObject(memdc,myBrush);
//	HBITMAP oldBit = (HBITMAP) SelectObject(memdc, hbit);
	Rectangle(memdc,CELL_SIZE*rowX,CELL_SIZE*colY,CELL_SIZE*(1+rowX)+1,CELL_SIZE*(1+colY)+1);
	InvalidateRect(mainWnd,NULL,0);
	SelectObject(memdc,hOldBrush);
	//SelectObject(memdc,oldBit);


}

void createMapQuads(int width , int height)
{
char info[125];
int w = width/CELL_SIZE;
int h = height/CELL_SIZE;
sprintf(info,"cells (%d,%d)",w,h);
//WriteTrace(TraceDebug,_T(info));
model.Init(w,h);
pather = new MicroPather((Graph *) &model );


}

void ProcessSelect(int x, int y)
{
/*
 #define MAP_SETUP   0 
 #define MARK_START   1 
 #define MARK_END   2 
 #define DRAW_PATH   3 

*/
int newState = 0;
HBRUSH useBrush = NULL;
POINT pt;
pt.x = pt.y = -1;
int test = 0;

if (x >= model.m_width)
	return;

if (y >= model.m_height)
	return;


 if (simulationState == MARK_START)
 {
	 //draw new
	 drawCell(x,y,startBrush);
	pt = model.getStartLocation();
	test = (x - pt.x)*(x-pt.x) +(y-pt.y)*(y-pt.y);

	if (pt.x > -1)
	{
	 // erase old
		if (test > 0)
			drawCell(pt.x,pt.y,whiteBrush);
	}
	model.processSelect(x,y,simulationState);

 }

 if (simulationState == MARK_END)
 {
	 //draw new
	 drawCell(x,y,endBrush);
	pt = model.getEndLocation();
	test = (x - pt.x)*(x-pt.x) +(y-pt.y)*(y-pt.y);

	if (pt.x > -1)
	{
	 // erase old
	if (test > 0)
		drawCell(pt.x,pt.y,whiteBrush);
	}
	model.processSelect(x,y,simulationState);

 }
 if (simulationState == MAP_SETUP)
 {
	model.processSelect(x,y,simulationState);
    newState = model.getStateForCell(x,y);
	if (newState == STATE_EMPTY)
	{
		useBrush = whiteBrush;
	}
	if (newState == STATE_GREEN)
	{
		useBrush = greenBrush;
	}
	if (newState == STATE_YELLOW)
	{
		useBrush = yellowBrush;
	}
	if (newState == STATE_RED)
	{
		useBrush = redBrush;
	}
	if (useBrush != NULL)
		drawCell(x,y,useBrush);

 }


}




void testDraw()
{

 void* ptr = NULL;
 void* startState = NULL;
 void* endState = NULL;
 solvedPath.clear();

float totalCost = 0;

POINT start = model.getStartLocation();
POINT end   = model.getEndLocation();
if (start.x < 0 || end.x < 0)
{

	MessageBox(mainWnd,"Must specify a start and end!","Error", MB_ICONSTOP | MB_OK);
	return;

}
startState = (void*) model.getQuad(start.x,start.y);
endState   = (void*) model.getQuad(end.x,end.y);
int result = -1;
result = 
  pather->Solve( startState, endState, &solvedPath, &totalCost );
char str[32];
sprintf(str,"$%4.2f",totalCost);
SetDlgItemText(dialogHWnd,IDC_TOTAL_COST,str);
if (result ==  MicroPather::SOLVED)
{
	InvalidateRect(mainWnd,NULL,0);
}
else
{
	solvedPath.resize(0);
	InvalidateRect(mainWnd,NULL,0);
	MessageBox(mainWnd,"Path not solvable!","Error", MB_ICONSTOP | MB_OK);


}
pather->Reset();


}


void cleanGrid()
{
	  
	model.resetModel();
	pather->Reset();
	solvedPath.clear();
	solvedPath.resize(0);
	drawGridToMem();
	simulationState = 0;
		SendDlgItemMessage(dialogHWnd, IDC_STEP_LIST,
                     LB_SETCURSEL, 0,0);
	SetDlgItemText(dialogHWnd,IDC_TOTAL_COST,"0.00");

	InvalidateRect(mainWnd,NULL,0);

}


void drawPath(HDC hdc)
{
// void pointers art to CMapQuads
	CMapQuad* mapquad = NULL;
	if (solvedPath.size() == 0)
		return;

	HPEN oldPen ;
	oldPen = (HPEN) SelectObject(hdc,linePen);
    mapquad = (CMapQuad*) solvedPath[0];
	MoveToEx(hdc,mapquad->m_x*CELL_SIZE + CELL_SIZE/2,mapquad->m_y*CELL_SIZE+CELL_SIZE/2+1,NULL);
	for(unsigned int k=1; k<solvedPath.size(); ++k )
	{
		
		mapquad = (CMapQuad*) solvedPath[k];
		LineTo(hdc,mapquad->m_x*CELL_SIZE+CELL_SIZE/2,mapquad->m_y*CELL_SIZE+CELL_SIZE/2+1);


	}

	SelectObject(hdc,oldPen);


}



