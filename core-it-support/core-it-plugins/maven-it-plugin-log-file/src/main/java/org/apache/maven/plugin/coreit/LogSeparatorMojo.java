package org.apache.maven.plugin.coreit;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Appends a separator line to the log file.
 *
 * @author Benjamin Bentmann
 *
  */
@Mojo( name = "log-separator", defaultPhase = LifecyclePhase.INITIALIZE )
public class LogSeparatorMojo
    extends AbstractLogMojo
{

    /**
     * The length of the separator line.
     */
    @Parameter( property = "log.length", defaultValue = "80" )
    private int length;

    /**
     * Runs this mojo.
     *
     * @throws MojoExecutionException If the output file could not be created.
     */
    public void execute()
        throws MojoExecutionException
    {
        StringBuilder buffer = new StringBuilder( length );
        for ( int i = 0; i < length; i++ )
        {
            buffer.append( '-' );
        }
        append( buffer.toString() );
    }

}
