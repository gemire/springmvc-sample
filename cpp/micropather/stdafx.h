// stdafx.h : include file for standard system include files,
// or project specific include files that are used frequently, but
// are changed infrequently
//

#pragma once


#define WIN32_LEAN_AND_MEAN		// Exclude rarely-used stuff from Windows headers
// Windows Header Files:
#include <windows.h>
// C RunTime Header Files
#include <stdlib.h>
#include <malloc.h>
#include <memory.h>
#include <tchar.h>
#include <assert.h>
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

// TODO: reference additional headers your program requires here
 #define MAP_SETUP   0 
 #define MARK_START   1 
 #define MARK_END   2 
 #define DRAW_PATH   3 
 #define STATE_GREEN   0 
 #define STATE_YELLOW   1 
 #define STATE_ORANGE   2 
 #define STATE_RED   3 
 #define STATE_EMPTY  4 
 #define STATE_START  5  
 #define STATE_END  6 
