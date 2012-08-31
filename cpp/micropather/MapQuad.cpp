#include "StdAfx.h"
#include ".\mapquad.h"
#include "XYTrace.h"
#include <float.h>

CMapQuad::CMapQuad(void)
: m_id(NULL)
{
	m_state = STATE_EMPTY;
	m_x = m_y = 0;
}


CMapQuad::CMapQuad(int x, int y)
{
	m_state = STATE_EMPTY;
	m_x = x;
	m_y = y;

}

CMapQuad::~CMapQuad(void)
{
}

void CMapQuad::PrintStateInfo(void)
{
	char ff[256];
	char ss[32];

	if (m_state == STATE_EMPTY)
		sprintf(ss,"EMPTY");
	if (m_state == STATE_GREEN)
		sprintf(ss,"GREEN");
	if (m_state == STATE_YELLOW)
		sprintf(ss,"YELLOW");
	if (m_state == STATE_RED)
		sprintf(ss,"RED");
	if (m_state == STATE_START)
		sprintf(ss,"START");
	if (m_state == STATE_ORANGE)
		sprintf(ss,"ORANGE");
	if (m_state == STATE_END)
		sprintf(ss,"END");


	sprintf(ff,"pos (%d,%d) id %d state %s",m_x, m_y, m_id, ss);
	WriteTrace(TraceDebug,ff);
}

float CMapQuad::getPenalty(void)
{

	float penalty = 2.0f;
	  
	if (m_state == STATE_GREEN)
		penalty = 10.0f;
	if (m_state == STATE_YELLOW)
		penalty = 20.0f;
	if (m_state == STATE_RED)
		penalty = 100.0f;
	if (m_state == STATE_ORANGE)
		penalty = 30.0f;
	return penalty;

}
