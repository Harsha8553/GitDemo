package dataProvider.dataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

import org.testng.annotations.Test;

public class Stream {
	
	@Test
	public void streamExec() {
		
		List<String> al=new ArrayList<String>();
		al.add("Arest");
		al.add("Harsha");
		al.add("Vassu");
		al.add("Adam");
		al.add("Alex");
		
		long hi=al.stream().filter(h->h.startsWith("A")).count();
		System.out.println(hi);
		
		long hello=al.stream().filter(d->
		{
			d.startsWith("A");
			return true;
		}).count();
		System.out.println(hello);
		
		al.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void stramMap() {
		
		List<String> names=Arrays.asList("Asta","Jack","Jaysey","Tom","Jerry");
		
		List<String> al=new ArrayList<String>();
		al.add("Arest");
		al.add("Harsha");
		al.add("Vassu");
		al.add("Adam");
		al.add("Alex");
		
//		names.stream().filter(s->s.startsWith("J")).sorted().map(s->s.toUpperCase())
//		.forEach(s->System.out.println(s));
		
		List<String> new1=names.stream().filter(s->s.startsWith("J")).sorted().map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(new1.get(1));
		
		boolean flag=names.stream().filter(s->s.startsWith("J")).anyMatch(s->s.equals("Jack"));
		System.out.println(flag);
	}
	

}
