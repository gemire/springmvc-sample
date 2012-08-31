#include "StdAfx.h"
#include ".\modelmanager.h"
#include "XYTrace.h"
#include <stdio.h>
#include <math.h>
#include <vector>

CModelManager::CModelManager(void)
{

	m_quads = NULL;
	int m_width = 0;
	int m_height = 0;
	m_currentStartIdx = m_currentEndIdx = -1;
}

CModelManager::~CModelManager(void)
{
	if (m_quads)
	{
		delete [] m_quads;
		m_quads = NULL;


	}
}

void CModelManager::Init(int width, int height)
{
	m_width = width;
	m_height = height;
	//char info[128];
	int v = 0;
	m_quads = new CMapQuad[m_width * m_height];


	for(int j=0;j<m_height;j++)
	{
		for(int i=0;i<m_width;i++)
		{
			m_quads[j*m_width + i].m_x = i;
			m_quads[j*m_width + i].m_y = j;
			v = j*m_width + i;
			m_quads[j*m_width + i].m_id =   v;
			//sprintf(info,"idx %d (%d,%d)\n",v,i,j);
			//WriteTrace(TraceDebug,_T(info));



		}

	}

}

void CModelManager::processSelect(int row, int col, int selectType)
{
	/*
	  global
	   int const MAP_SETUP = 0;
 int const MARK_START = 1;
 int const MARK_END = 2;
 int const DRAW_PATH = 3;
	*/
	CMapQuad* currentQuad = &m_quads[col*m_width + row];
	
	switch(selectType)
	{
	case MAP_SETUP:
		if (currentQuad->m_state == STATE_EMPTY)
		{
			currentQuad->m_state = STATE_GREEN;
			break;
		}
		if (currentQuad->m_state == STATE_GREEN)
		{
			currentQuad->m_state = STATE_YELLOW;
			break;

		}
		if (currentQuad->m_state == STATE_YELLOW)
		{
			currentQuad->m_state = STATE_RED;
			break;
		}
		if (currentQuad->m_state == STATE_RED)
		{
			currentQuad->m_state = STATE_EMPTY;
			break;
		}

		break;
	case MARK_START:
		currentQuad->m_state = STATE_START;
		if (m_currentStartIdx > -1)
			m_quads[m_currentStartIdx].m_state = STATE_EMPTY;
		m_currentStartIdx = col*m_width + row;
		break;

	case MARK_END:
		currentQuad->m_state = STATE_END;
		if (m_currentEndIdx > -1)
			m_quads[m_currentEndIdx].m_state = STATE_EMPTY;
		m_currentEndIdx = col*m_width + row;
		break;

	}


}

int CModelManager::getStateForCell(int row, int col)
{
	return m_quads[col*m_width + row].m_state;
}


POINT CModelManager::getStartLocation()
{

	POINT newPoint;
	newPoint.x = newPoint.y = -1;
	if (this->m_currentStartIdx > -1)
	{
		newPoint.x = m_quads[m_currentStartIdx].m_x;
		newPoint.y = m_quads[m_currentStartIdx].m_y;
		
	}

	return newPoint;

}

POINT CModelManager::getEndLocation()
{
	POINT newPoint;
	newPoint.x = newPoint.y = -1;
	if (this->m_currentEndIdx > -1)
	{
	newPoint.x = m_quads[m_currentEndIdx].m_x;
	newPoint.y = m_quads[m_currentEndIdx].m_y;
		
	}
	return newPoint;
}

float CModelManager::LeastCostEstimate( void* nodeStart, void* nodeEnd )
{
	float estimate = 0.0f;
	CMapQuad* endQuad = (CMapQuad*) nodeEnd;
	CMapQuad* startQuad = (CMapQuad*) nodeStart;
	int dx = startQuad->m_x - endQuad->m_x;
	int dy = startQuad->m_y - endQuad->m_y;
	estimate = (float) sqrt( (double)(dx*dx) + (double)(dy*dy) );
	return estimate;

}

	void CModelManager::PrintStateInfo(void * quadptr)
	{
		CMapQuad* quad = (CMapQuad*) quadptr;
		quad->PrintStateInfo();

	}




	void CModelManager::AdjacentCost(void *node,vector<StateCost> *neighbors)
	{
		const int dx[4] = { 1,  0,  -1,   0 };
		const int dy[4] = { 0,  1,   0,  -1 };

		CMapQuad* quad = (CMapQuad*) node;

		for( int i=0; i<4; ++i ) 
		{
			int nx = quad->m_x + dx[i];
			int ny = quad->m_y + dy[i];
			if (nx < 0 || ny < 0 || nx >= m_width || ny >= m_height || quad->m_state == STATE_RED)
			{
			 //not a neighbor

			}
			else
			{
			  CMapQuad* neighborQuad = getQuad(nx,ny);
			  float penalty = neighborQuad->getPenalty();
			  StateCost nodeCost = {(void *) neighborQuad,penalty  };
			  neighbors->push_back( nodeCost );


			}


		}


	}

	CMapQuad* CModelManager::getQuad(int row, int col)
	{
		return &m_quads[col*m_width + row];
	}

	void CModelManager::resetModel(void)
	{

		
		m_currentEndIdx = m_currentStartIdx = -1;
	 
		for(int j=0;j< m_height;j++)
		{
			for(int i=0;i<m_width;i++)
			{
	             
				getQuad(i,j)->m_state = STATE_EMPTY;

			}

		}
	 


	}
