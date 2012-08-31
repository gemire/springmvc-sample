#pragma once
#include "mapquad.h"


class CMapQuad
{
public:
	CMapQuad(void);
	~CMapQuad(void);
    CMapQuad(int x, int y);

	int m_state;
	int m_x, m_y;

	int m_id;
	void PrintStateInfo(void);
	float getPenalty(void);
};
