#pragma once
#include "micropather\micropather.h"
#include "mapquad.h" 
using namespace std;

using  namespace micropather;

class CModelManager: public Graph
{
public:
	CModelManager(void);
	virtual ~CModelManager(void);
	int m_width, m_height;	
	void Init(int width, int height);
	void processSelect(int row, int col, int selectType);
	int getStateForCell(int row, int col);
	POINT getStartLocation();
	POINT getEndLocation();
	float LeastCostEstimate(void *,void *);
	void AdjacentCost(void *,std::vector<StateCost> *);
	void PrintStateInfo(void *);
private: 
	CMapQuad* m_quads;
    int m_currentEndIdx, m_currentStartIdx;


public:
	CMapQuad* getQuad(int row, int col);
	void resetModel(void);
};
