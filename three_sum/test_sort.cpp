#include <iostream>
#include <algorithm>
#include <vector>

int main()
{
  int myints[] = {15,2,77,29};
  std::vector<int> myvector(myints,myints+4);

  std::sort(myvector.begin(), myvector.end());

  std::cout<<"myvector contains:";
  for (std::vector<int>::iterator it=myvector.begin(); it!=myvector.end(); ++it)
    std::cout << ' ' << *it;
  std::cout << '\n';

  return 0;
}
  
