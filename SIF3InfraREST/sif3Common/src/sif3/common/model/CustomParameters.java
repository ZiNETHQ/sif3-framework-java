/*
 * CustomParameters.java
 * Created: 26/05/2015
 *
 * Copyright 2015 Systemic Pty Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License 
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package sif3.common.model;

/**
 * This class is a extension of the RequestParameter class.
 * 
 * @author Joerg Huber
 */
public class CustomParameters extends RequestParameters
{
    private static final long serialVersionUID = 7749662743830560594L;

	@Override
    public String toString()
    {
	    return "CustomParameters [toString()=" + super.toString() + "]";
    }
}
