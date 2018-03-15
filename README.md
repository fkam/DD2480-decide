## DD2480-decide

# Anti-ballistic missile system

This is a program that decides if we should launch anti-ballistic missiles at flying objects given inputs based on observation.

## Manual:

## Requirments 
* Java JDK : v.1.8+

* [Maven](https://maven.apache.org/) : v.3.5.2+

## Testing
Each public function and whole system implementation is tested under test folder.

## List of Contributors
#### Marcus Lignercrona:
Contributed by writing code and improving upon such as the functionally for generating Lic 1,2,6,7 also code in help functions such as the Lcm class and angle function in GeometryHelper reviewed code during pull request and took part in several discussions regarding code and implementation.

#### Jiayu Sun:

#### Felix Kam:
- Contributed with creating the code structure.
- Implemented Maven.
- Implemented CMV 0.
- Implemented CMV 7.
- Implemented CMV 8.
- Implemented FUV.
- Implemented Launch.
- Code reviewing.
- Discussions within teh group.

#### François Castle:

#### Jonas Olofsson:
Contributed with code and managing the repo. I have done a lot of reviewing of code during pull requests. Also been active in several discussions regarding code and implementations.

## Important words
Word | Meaning
------------ | -------------
CMV | (Conditions Met Vector) The CMV is a boolean vector whose elements have a one-to-one correspondence with the launch interceptor conditions. If the radar tracking data satisfy a certain LIC, then the corresponding element of the CMV is to be set to true.
FUV | (Final Unlocking Vector) The FUV is a boolean vector which is the basis for deciding whether to launch an interceptor.If all elements of the FUV are true, a launch should occur 
LCM | (Logical Connector Matrix) The LCM describes how individual LIC’s should be logically combined. For example, the value of LCM[i,j] indicates whether LIC #i should combine with LIC #j by the logical AND, OR, or not at all.
LIC | (Launch Interceptor Condition) If radar tracking data exhibit a certain combination of characteristics, then an interceptor should be launched. Each characteristic is an LIC.
PUM | (Preliminary Unlocking Matrix) Every element of the boolean PUM corresponds to an element of the LCM. If the logical connection dictated by the LCM element gives the value “true”, the corresponding PUM element is to be set to true.
