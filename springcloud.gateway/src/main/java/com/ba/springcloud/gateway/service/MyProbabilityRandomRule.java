package com.ba.springcloud.gateway.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * @author Administrator
 * @date 2019年4月3日
 * @version 1.0
 */
public class MyProbabilityRandomRule extends AbstractLoadBalancerRule {
	
	Random rand;

    public MyProbabilityRandomRule() {
        rand = new Random();
    }
    
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
//            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            final int number = rand.nextInt(10);
    		if (number < 1) {
    			server = findServer(allList,7001);
    		} else if(number < 8) {
    			server =  findServer(allList,7002);
    		} else {
    			server =  findServer(allList,7003);
    		}
        }

        return server;
		
	}

	private Server findServer(List<Server> allServers, int port) {
		for (Server server : allServers) {
			if (server.getPort() == port) {
				return server;
			}
		}
		System.out.println("NULL port="+port);
		return null;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

}
