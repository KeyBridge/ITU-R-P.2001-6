#
#  REC P.528-5 INTEGRAL SOFTWARE
#
####################################

Author:  William Kozma Jr
         wkozma@ntia.gov
         US Dept of Commerce, NTIA/ITS
         May/June 2022 : Geneva Study Group 3 Meetings


|
| Descripton
|---------------------|

This package contains a software implementation of Rec P.528-5, "Propagation 
curves for aeronautical mobile and radionavigation services using the VHF, 
UHF and SHF bands."  The software was written is C++ using only the standard
C++ languages libraries (such as math.lib).  The software has been verified
that is can be compiled on Windows 7/10, MacOS, and Linux.


|
| Code Style
|---------------------|

The software was written in a mannar to maximize tracability back to the
Recommendation's text and equations.  Each file has a header comment block,
which in most cases points directly to a section of Annex 2.  Where possible,
equations are numbered based on the equation numbers in the Recommendation.

Variables are named in a "pseudo-LaTeX", to assist in mapping back to variables
int the Recommendation.  In general, a single underscore ('_') represents a 
subscript, while a double underscore ('__') is used to label the units
on the value.


|
| Functions
|---------------------|

The library contains a single function,

   int P528(double d__km, double h_1__meter, double h_2__meter, 
	double f__mhz, int T_pol, double p, Result *result)

to call the model.  Please read the file p528.h in the /include/
directory for more information on the function call.


|
| Inputs
|---------------------|

Inputs to the model are as follows:

  - d__km           : Path distance, in km
                      Range: 0 <= d__km

  - h_1__meter      : Height of the low terminal, in meters
                      Range*: 1.5 <= h_1__meter <= 20 000

  - h_2__meter      : Height of the high terminal, in meters
                      Range*: 1.5 <= h_2__meter <= 20 000

  - f__mhz          : Frequency, in MHz
                      Range: 100 <= f__mhz <= 30 000

  - p               : Time percentage
                      Range: 1 <= p <= 99

  - T_pol           : Polarizaton
                        + 0 = HORIZONTAL
                        + 1 = VERTICAL

* Additionally, h_1__meter <= h_2__meter is required


|
| Return Codes
|---------------------|

The DLL can return errors and warnings (values other than '0').  Please
check the file p528.h in /include/ to check their meaning.


|
| Validation Examples
|---------------------|

To validate the execution of the source code, use the P.528-5
data tables, which are in CSV format.  These data tables were generated
with this source code compiled with Visual Studio 2019 on Windows 10.

This software was developed by employees of the National Telecommunications 
and Information Administration (NTIA), an agency of the Federal Government 
and is provided to you as a public service. Pursuant to Title 15 United States 
Code Section 105, works of NTIA employees are not subject to copyright p
rotection within the United States.

The software is provided by NTIA “AS IS.” NTIA MAKES NO WARRANTY OF ANY 
KIND, EXPRESS, IMPLIED OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE 
IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, 
NON-INFRINGEMENT AND DATA ACCURACY. NTIA does not warrant or make any 
representations regarding the use of the software or the results thereof, 
including but not limited to the correctness, accuracy, reliability or 
usefulness of the software.

To the extent that NTIA holds rights in countries other than the United 
States, you are hereby granted the non-exclusive irrevocable and 
unconditional right to print, publish, prepare derivative works and 
distribute the NTIA software, in any medium, or authorize others to do 
so on your behalf, on a royalty-free basis throughout the World.

You may improve, modify, and create derivative works of the software 
or any portion of the software, and you may copy and distribute such 
modifications or works. Modified works should carry a notice stating 
that you changed the software and should note the date and nature of 
any such change.

You are solely responsible for determining the appropriateness of 
using and distributing the software and you assume all risks associated 
with its use, including but not limited to the risks and costs of 
program errors, compliance with applicable laws, damage to or loss 
of data, programs or equipment, and the unavailability or interruption 
of operation. This software is not intended to be used in any situation 
where a failure could cause risk of injury or damage to property.

Please provide appropriate acknowledgments of NTIA’s creation of the s
oftware in any copies or derivative works of this software.